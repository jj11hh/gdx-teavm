package com.github.xpenatan.gdx.backends.teavm.dom.typedarray;

import org.teavm.jso.JSIndexer;
import org.teavm.jso.JSProperty;

/**
 * @author xpenatan
 */
public interface Float32ArrayWrapper extends ArrayBufferViewWrapper {
    // Float32Array
    static final int BYTES_PER_ELEMENT = 4;

    @JSProperty
    int getLength();

    @JSIndexer
    float get(int index);

    @JSIndexer
    void set(int index, float value);

    void set(Float32ArrayWrapper array);

    void set(Float32ArrayWrapper array, int offset);

    void set(FloatArrayWrapper array);

    void set(FloatArrayWrapper array, int offset);

    Float32ArrayWrapper subarray(int start, int end);
}