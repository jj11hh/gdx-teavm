package com.github.xpenatan.gdx.backends.teavm;

import java.util.Set;
import org.teavm.jso.JSIndexer;
import org.teavm.jso.JSMethod;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;
import org.teavm.model.AnnotationContainer;
import org.teavm.model.AnnotationHolder;
import org.teavm.model.AnnotationValue;
import org.teavm.model.ClassHolder;
import org.teavm.model.ClassHolderTransformer;
import org.teavm.model.ClassHolderTransformerContext;
import org.teavm.model.ClassReaderSource;
import org.teavm.model.MethodHolder;
import com.github.xpenatan.gdx.backend.web.WebAgentInfo;
import com.github.xpenatan.gdx.backend.web.dom.DocumentWrapper;
import com.github.xpenatan.gdx.backend.web.dom.ElementWrapper;
import com.github.xpenatan.gdx.backend.web.dom.EventListenerWrapper;
import com.github.xpenatan.gdx.backend.web.dom.EventTargetWrapper;
import com.github.xpenatan.gdx.backend.web.dom.EventWrapper;
import com.github.xpenatan.gdx.backend.web.dom.HTMLCanvasElementWrapper;
import com.github.xpenatan.gdx.backend.web.dom.HTMLDocumentWrapper;
import com.github.xpenatan.gdx.backend.web.dom.HTMLElementWrapper;
import com.github.xpenatan.gdx.backend.web.dom.HTMLImageElementWrapper;
import com.github.xpenatan.gdx.backend.web.dom.HTMLVideoElementWrapper;
import com.github.xpenatan.gdx.backend.web.dom.ImageDataWrapper;
import com.github.xpenatan.gdx.backend.web.dom.KeyboardEventWrapper;
import com.github.xpenatan.gdx.backend.web.dom.MouseEventWrapper;
import com.github.xpenatan.gdx.backend.web.dom.NodeWrapper;
import com.github.xpenatan.gdx.backend.web.dom.TouchEventWrapper;
import com.github.xpenatan.gdx.backend.web.dom.TouchListWrapper;
import com.github.xpenatan.gdx.backend.web.dom.TouchWrapper;
import com.github.xpenatan.gdx.backend.web.dom.WheelEventWrapper;
import com.github.xpenatan.gdx.backend.web.dom.typedarray.ArrayBufferViewWrapper;
import com.github.xpenatan.gdx.backend.web.dom.typedarray.ArrayBufferWrapper;
import com.github.xpenatan.gdx.backend.web.dom.typedarray.Float32ArrayWrapper;
import com.github.xpenatan.gdx.backend.web.dom.typedarray.Float64ArrayWrapper;
import com.github.xpenatan.gdx.backend.web.dom.typedarray.FloatArrayWrapper;
import com.github.xpenatan.gdx.backend.web.dom.typedarray.Int16ArrayWrapper;
import com.github.xpenatan.gdx.backend.web.dom.typedarray.Int32ArrayWrapper;
import com.github.xpenatan.gdx.backend.web.dom.typedarray.LongArrayWrapper;
import com.github.xpenatan.gdx.backend.web.dom.typedarray.ObjectArrayWrapper;
import com.github.xpenatan.gdx.backend.web.dom.typedarray.Uint8ArrayWrapper;
import com.github.xpenatan.gdx.backend.web.gl.WebGLActiveInfoWrapper;
import com.github.xpenatan.gdx.backend.web.gl.WebGLBufferWrapper;
import com.github.xpenatan.gdx.backend.web.gl.WebGLContextAttributesWrapper;
import com.github.xpenatan.gdx.backend.web.gl.WebGLFramebufferWrapper;
import com.github.xpenatan.gdx.backend.web.gl.WebGLProgramWrapper;
import com.github.xpenatan.gdx.backend.web.gl.WebGLRenderbufferWrapper;
import com.github.xpenatan.gdx.backend.web.gl.WebGLRenderingContextWrapper;
import com.github.xpenatan.gdx.backend.web.gl.WebGLShaderWrapper;
import com.github.xpenatan.gdx.backend.web.gl.WebGLTextureWrapper;
import com.github.xpenatan.gdx.backend.web.gl.WebGLUniformLocationWrapper;

/**
 * @author xpenatan
 */
public class TeaClassTransformer implements ClassHolderTransformer {

	private boolean init = false;

	@Override
	public void transformClass(ClassHolder cls, ClassHolderTransformerContext context) {
		if(!init) {
			init = true;

			ClassHolder classHolder = null;
			classHolder = findClassHolder(context, Float32ArrayWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSIndexer.class, "set", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getLength", null);

			classHolder = findClassHolder(context, Int32ArrayWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSIndexer.class, "set", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getLength", null);

			classHolder = findClassHolder(context, Int16ArrayWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSIndexer.class, "set", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getLength", null);

			classHolder = findClassHolder(context, Uint8ArrayWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSIndexer.class, "set", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getLength", null);

			classHolder = findClassHolder(context, Float64ArrayWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSIndexer.class, "set", null);

			classHolder = findClassHolder(context, WebGLTextureWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);

			classHolder = findClassHolder(context, WebGLUniformLocationWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, WebGLShaderWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, WebGLRenderbufferWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, WebGLProgramWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, WebGLFramebufferWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, WebGLContextAttributesWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, WebGLBufferWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, WebGLActiveInfoWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getSize", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getType", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getName", null);

			classHolder = findClassHolder(context, WebGLRenderingContextWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSMethod.class, "getParameterInt", "getParameter");
			setMethodAnnotation(classHolder,  JSMethod.class, "getParameterFloat", "getParameter");
			setMethodAnnotation(classHolder,  JSMethod.class, "getParameterString", "getParameter");
			setMethodAnnotation(classHolder,  JSMethod.class, "getProgramParameterInt", "getProgramParameter");
			setMethodAnnotation(classHolder,  JSMethod.class, "getProgramParameterBoolean", "getProgramParameter");
			setMethodAnnotation(classHolder,  JSMethod.class, "getShaderParameterBoolean", "getShaderParameter");
			setMethodAnnotation(classHolder,  JSMethod.class, "getShaderParameterInt", "getShaderParameter");

			classHolder = findClassHolder(context, ArrayBufferViewWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, ArrayBufferWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, ObjectArrayWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, LongArrayWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, ImageDataWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, HTMLImageElementWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, HTMLVideoElementWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			classHolder = findClassHolder(context, HTMLCanvasElementWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getWidth", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "setWidth", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getHeight", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "setHeight", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getOwnerDocument", null);

			classHolder = findClassHolder(context, FloatArrayWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);

			classHolder = findClassHolder(context, EventTargetWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);

			classHolder = findClassHolder(context, EventListenerWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);

			classHolder = findClassHolder(context, EventWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getTarget", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getType", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getDetail", null);

			classHolder = findClassHolder(context, WheelEventWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getDeltaX", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getDeltaY", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getDeltaZ", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getWheelDelta", null);

			classHolder = findClassHolder(context, MouseEventWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getClientX", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getClientY", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getMovementX", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getMovementY", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getButton", null);

			classHolder = findClassHolder(context, KeyboardEventWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getCharCode", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getKeyCode", null);

			classHolder = findClassHolder(context, TouchEventWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getChangedTouches", null);

			classHolder = findClassHolder(context, TouchListWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getLength", null);

			classHolder = findClassHolder(context, TouchWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getIdentifier", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getClientX", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getClientY", null);

			classHolder = findClassHolder(context, WebAgentInfo.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "isFirefox", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "isChrome", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "isSafari", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "isOpera", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "isIE", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "isMacOS", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "isLinux", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "isWindows", null);

			classHolder = findClassHolder(context, DocumentWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getCompatMode", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getDocumentElement", null);

			classHolder = findClassHolder(context, ElementWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getScrollTop", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getScrollLeft", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getClientWidth", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getClientHeight", null);

			classHolder = findClassHolder(context, HTMLElementWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getOffsetParent", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getOffsetTop", null);
			setMethodAnnotation(classHolder,  JSProperty.class, "getOffsetLeft", null);

			classHolder = findClassHolder(context, NodeWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getParentNode", null);

			classHolder = findClassHolder(context, HTMLDocumentWrapper.class);
			setClassAnnotation(classHolder, JSObject.class);
			setMethodAnnotation(classHolder,  JSProperty.class, "getParentNode", null);
		}
	}

	private ClassHolder findClassHolder(ClassHolderTransformerContext context, Class clazz) {
		ClassReaderSource innerSource = context.getHierarchy().getClassSource();
		ClassHolder classHolder = (ClassHolder)innerSource.get(clazz.getName());
		return classHolder;
	}

	private void setMethodAnnotation(ClassHolder classHolder, Class annotationClass, String methodStr, String value) {
		for (MethodHolder method : classHolder.getMethods().toArray(new MethodHolder[0])) {
			String name = method.getName();
			if (name.equals(methodStr)) {
				AnnotationContainer annotations = method.getAnnotations();
				AnnotationHolder annotation = new AnnotationHolder(annotationClass.getName());
				if(value != null) {
					annotation.getValues().put("value", new AnnotationValue(value));
				}
				annotations.add(annotation);
			}

		}
	}

	private void setClassAnnotation(ClassHolder classHolder, Class annotationClass) {
		Set<String> interfaces = classHolder.getInterfaces();
		interfaces.add(JSObject.class.getName());
	}

}