package com.github.xpenatan.gdx.backends.teavm.dom;

import org.teavm.jso.dom.html.HTMLCanvasElement;
import org.teavm.jso.webgl.WebGLContextAttributes;

import com.github.xpenatan.gdx.backend.web.WebAgentInfo;
import com.github.xpenatan.gdx.backend.web.WebApplicationConfiguration;
import com.github.xpenatan.gdx.backend.web.WebJSHelper;
import com.github.xpenatan.gdx.backend.web.dom.HTMLCanvasElementWrapper;
import com.github.xpenatan.gdx.backend.web.dom.WindowWrapper;
import com.github.xpenatan.gdx.backend.web.gl.WebGLRenderingContextWrapper;

/**
 * @author xpenatan
 */
public class TeaJSHelper implements WebJSHelper {

	private WindowWrapper window;
	private WebAgentInfo agentInfo;
	private HTMLCanvasElementWrapper canvasWrapper;

	public TeaJSHelper(WebAgentInfo agentInfo, HTMLCanvasElementWrapper canvasWrapper) {
		this.agentInfo = agentInfo;
		this.canvasWrapper = canvasWrapper;
	}

	@Override
	public WebGLRenderingContextWrapper getGLContext(WebApplicationConfiguration config) {
		WebGLContextAttributes attr = WebGLContextAttributes.create();
		attr.setAlpha(config.alpha);
		attr.setAntialias(config.antialiasing);
		attr.setStencil(config.stencil);
		attr.setPremultipliedAlpha(config.premultipliedAlpha);
		attr.setPreserveDrawingBuffer(config.preserveDrawingBuffer);
		HTMLCanvasElement canvas = (HTMLCanvasElement)canvasWrapper;
		WebGLRenderingContextWrapper context = (WebGLRenderingContextWrapper)canvas.getContext("webgl", attr);
		return context;
	}

	@Override
	public HTMLCanvasElementWrapper getCanvas() {
		return canvasWrapper;
	}

	@Override
	public WindowWrapper getCurrentWindow() {
		return new TeaWindow();
	}

	@Override
	public WebAgentInfo getAgentInfo() {
		return agentInfo;
	}
}