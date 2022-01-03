package com.github.xpenatan.gdx.html5.bullet.teavm;

import com.github.javaparser.TokenRange;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.comments.BlockComment;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.xpenatan.gdx.html5.bullet.codegen.CodeGenParser;
import com.github.xpenatan.gdx.html5.bullet.codegen.CodeGenParserItem;
import com.github.xpenatan.gdx.html5.bullet.codegen.util.RawCodeBlock;
import java.util.Optional;

/** @author xpenatan */
public class TeaVMCodeParser implements CodeGenParser {

    public static final String CMD_HEADER = "[-teaVM";
    public static final String CMD_ADD = "-ADD";
    public static final String CMD_REMOVE = "-REMOVE";
    public static final String CMD_REPLACE = "-REPLACE";
    public static final String CMD_NATIVE = "-NATIVE";

    private void updateBlock(CodeGenParserItem parserItem) {
        for(int i = 0; i < parserItem.rawComments.size(); i++) {
            BlockComment rawBlockComment = parserItem.rawComments.get(i);
            String headerCommands = CodeGenParserItem.obtainHeaderCommands(rawBlockComment);
            // Remove comment block if its not part of this parser
            if(headerCommands == null || !headerCommands.startsWith(CMD_HEADER)) {
                rawBlockComment.remove();
                parserItem.rawComments.remove(i);
                i--;
            }
        }
    }

    @Override
    public void parseCodeBlock(CodeGenParserItem parserItem) {
        updateBlock(parserItem);

        if(parserItem.rawComments.size() == 0) {
            return;
        }
        // should only work with 1 block comment
        BlockComment blockComment = parserItem.rawComments.get(0);

        // Remove raw block comment from source
        blockComment.remove();

        String headerCommands = CodeGenParserItem.obtainHeaderCommands(blockComment);
        if(headerCommands == null)
            return;

        if(parserItem.isFieldBlock()) {
            FieldDeclaration fieldDeclaration = parserItem.fieldDeclaration;
            if(headerCommands.contains(CMD_REPLACE)) {
                setJavaBodyReplaceCMD(parserItem, headerCommands, blockComment, fieldDeclaration);
            }
        }
        else if(parserItem.isMethodBlock()) {
            MethodDeclaration methodDeclaration = parserItem.methodDeclaration;

            if(methodDeclaration.isNative()) {
                if(headerCommands.contains(CMD_NATIVE)) {
                    setJavaBodyNativeCMD(headerCommands, blockComment, methodDeclaration);
                }
            }
            if(headerCommands.contains(CMD_REPLACE)) {
                setJavaBodyReplaceCMD(parserItem, headerCommands, blockComment, methodDeclaration);
            }
        }
        // Block comments without field or method
        if(headerCommands.contains(CMD_ADD)) {
            setJavaBodyAddCMD(parserItem, headerCommands, blockComment);
        }
        else if(headerCommands.contains(CMD_REMOVE)) {
            setJavaBodyRemoveCMD(parserItem);
        }
    }

    @Override
    public void parseHeaderBlock(CodeGenParserItem parserItem) {
        updateBlock(parserItem);

        if(parserItem.rawComments.size() == 0) {
            return;
        }
        // should only work with 1 block comment
        BlockComment blockComment = parserItem.rawComments.get(0);
        // Remove raw block comment from source
        blockComment.remove();

        String headerCommands = CodeGenParserItem.obtainHeaderCommands(blockComment);

        if(parserItem.isImportBlock()) {
            if(headerCommands.contains(CMD_REPLACE)) {
                setJavaHeaderReplaceCMD(parserItem, headerCommands, blockComment, parserItem.importDeclaration);
            }
        }

        if(headerCommands.contains(CMD_ADD)) {
            setJavaHeaderAddCMD(parserItem, headerCommands, blockComment);
        }
        else if(headerCommands.contains(CMD_REMOVE)) {
            setJavaHeaderRemoveCMD(parserItem);
        }
    }

    private void setJavaHeaderReplaceCMD(CodeGenParserItem parserItem, String headerCommands, BlockComment blockComment, ImportDeclaration importDeclaration) {
        importDeclaration.remove();
        String content = CodeGenParserItem.obtainContent(headerCommands, blockComment);
        RawCodeBlock newblockComment = new RawCodeBlock();
        newblockComment.setContent(content);
        Optional<TokenRange> tokenRange = importDeclaration.getTokenRange();
        TokenRange javaTokens = tokenRange.get();
        newblockComment.setTokenRange(javaTokens);
        parserItem.unit.addType(newblockComment);
    }

    private void setJavaHeaderAddCMD(CodeGenParserItem parserItem, String headerCommands, BlockComment blockComment) {
        String content = CodeGenParserItem.obtainContent(headerCommands, blockComment);
        RawCodeBlock newblockComment = new RawCodeBlock();
        newblockComment.setContent(content);
        Optional<TokenRange> tokenRange = blockComment.getTokenRange();
        TokenRange javaTokens = tokenRange.get();
        newblockComment.setTokenRange(javaTokens);
        parserItem.unit.addType(newblockComment);
    }

    private void setJavaBodyAddCMD(CodeGenParserItem parserItem, String headerCommands, BlockComment blockComment) {
        String content = CodeGenParserItem.obtainContent(headerCommands, blockComment);
        RawCodeBlock newblockComment = new RawCodeBlock();
        ClassOrInterfaceDeclaration classInterface = parserItem.classInterface;
        newblockComment.setContent(content);
        Optional<TokenRange> tokenRange = blockComment.getTokenRange();
        TokenRange javaTokens = tokenRange.get();
        newblockComment.setTokenRange(javaTokens);
        classInterface.getMembers().add(newblockComment);
    }

    private void setJavaHeaderRemoveCMD(CodeGenParserItem parserItem) {
        setJavaBodyRemoveCMD(parserItem);
    }

    private void setJavaBodyNativeCMD(String headerCommands, BlockComment blockComment, MethodDeclaration methodDeclaration) {
        NodeList<Parameter> parameters = methodDeclaration.getParameters();
        int size = parameters.size();

        String content = CodeGenParserItem.obtainContent(headerCommands, blockComment);

        String param = "";

        for(int i = 0; i < size; i++) {
            Parameter parameter = parameters.get(i);
            SimpleName name = parameter.getName();
            param += name;
            if(i < size - 1) {
                param += "\", \"";
            }
        }

        if(content != null) {
            content = content.replace("\n", "");
            content = content.trim();

            if(!content.isEmpty()) {
                NormalAnnotationExpr normalAnnotationExpr = methodDeclaration.addAndGetAnnotation("org.teavm.jso.JSBody");
                if(!param.isEmpty()) {
                    normalAnnotationExpr.addPair("params", "{\"" + param + "\"}");
                }
                normalAnnotationExpr.addPair("script", "\"" + content + "\"");
            }
        }
    }

    private void setJavaBodyReplaceCMD(CodeGenParserItem parserItem, String headerCommands, BlockComment blockComment, MethodDeclaration methodDeclaration) {
        methodDeclaration.remove();
        ClassOrInterfaceDeclaration classInterface = parserItem.classInterface;
        String content = CodeGenParserItem.obtainContent(headerCommands, blockComment);
        RawCodeBlock newblockComment = new RawCodeBlock();
        newblockComment.setContent(content);
        Optional<TokenRange> tokenRange = methodDeclaration.getTokenRange();
        TokenRange javaTokens = tokenRange.get();
        newblockComment.setTokenRange(javaTokens);
        classInterface.getMembers().add(newblockComment);
    }

    private void setJavaBodyReplaceCMD(CodeGenParserItem parserItem, String headerCommands, BlockComment blockComment, FieldDeclaration fieldDeclaration) {
        fieldDeclaration.remove();
        ClassOrInterfaceDeclaration classInterface = parserItem.classInterface;
        String content = CodeGenParserItem.obtainContent(headerCommands, blockComment);
        RawCodeBlock newblockComment = new RawCodeBlock();
        newblockComment.setContent(content);
        Optional<TokenRange> tokenRange = fieldDeclaration.getTokenRange();
        TokenRange javaTokens = tokenRange.get();
        newblockComment.setTokenRange(javaTokens);
        classInterface.getMembers().add(newblockComment);
    }

    private void setJavaBodyRemoveCMD(CodeGenParserItem parserItem) {
        parserItem.removeAll();
    }
}