/*-------------------------------------------------------
 * This file was generated by XpeCodeGen
 * Version 1.0.0
 *
 * Do not make changes to this file
 *-------------------------------------------------------*/
package com.badlogic.gdx.physics.bullet.collision;

import com.badlogic.gdx.physics.bullet.BulletBase;
import com.badlogic.gdx.physics.bullet.linearmath.btIDebugDraw;

/** @author xpenatan */
public class btDispatcherInfo extends BulletBase {

    public btDispatcherInfo(long cPtr, boolean cMemoryOwn) {
        resetObj(cPtr, cMemoryOwn);
    }

	protected void cacheObj() {
		com.dragome.commons.javascript.ScriptHelper.put("addr",this.cPointer,this);
		this.jsObj = com.dragome.commons.javascript.ScriptHelper.eval("Bullet.wrapPointer(addr,Bullet.btDispatcherInfo);",this);
	}

    public void setTimeStep(float value) {
		com.dragome.commons.javascript.ScriptHelper.put("value",value,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("jsObj.set_m_timeStep(value);",this);
    }

    public float getTimeStep() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalFloat("jsObj.get_m_timeStep();",this);
    }

    public void setStepCount(int value) {
		com.dragome.commons.javascript.ScriptHelper.put("value",value,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("jsObj.set_m_stepCount(value);",this);
    }

    public int getStepCount() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalInt("jsObj.get_m_stepCount();",this);
    }

    public void setDispatchFunc(int value) {
		com.dragome.commons.javascript.ScriptHelper.put("value",value,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("jsObj.set_m_dispatchFunc(value);",this);
    }

    public int getDispatchFunc() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalInt("jsObj.get_m_dispatchFunc();",this);
    }

    public void setTimeOfImpact(float value) {
		com.dragome.commons.javascript.ScriptHelper.put("value",value,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("jsObj.set_m_timeOfImpact(value);",this);
    }

    public float getTimeOfImpact() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalFloat("jsObj.get_m_timeOfImpact();",this);
    }

    public void setUseContinuous(boolean value) {
		com.dragome.commons.javascript.ScriptHelper.put("value",value,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("jsObj.set_m_useContinuous(value);",this);
    }

    public boolean getUseContinuous() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalBoolean("jsObj.get_m_useContinuous();",this);
    }

    public void setEnableSatConvex(boolean value) {
		com.dragome.commons.javascript.ScriptHelper.put("value",value,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("jsObj.set_m_enableSatConvex(value);",this);
    }

    public boolean getEnableSatConvex() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalBoolean("jsObj.get_m_enableSatConvex();",this);
    }

    public void setEnableSPU(boolean value) {
		com.dragome.commons.javascript.ScriptHelper.put("value",value,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("jsObj.set_m_enableSPU(value);",this);
    }

    public boolean getEnableSPU() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalBoolean("jsObj.get_m_enableSPU();",this);
    }

    public void setUseEpa(boolean value) {
		com.dragome.commons.javascript.ScriptHelper.put("value",value,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("jsObj.set_m_useEpa(value);",this);
    }

    public boolean getUseEpa() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalBoolean("jsObj.get_m_useEpa();",this);
    }

    public void setAllowedCcdPenetration(float value) {
		com.dragome.commons.javascript.ScriptHelper.put("value",value,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("jsObj.set_m_allowedCcdPenetration(value);",this);
    }

    public float getAllowedCcdPenetration() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalFloat("jsObj.get_m_allowedCcdPenetration();",this);
    }

    public void setUseConvexConservativeDistanceUtil(boolean value) {
		com.dragome.commons.javascript.ScriptHelper.put("value",value,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("jsObj.set_m_useConvexConservativeDistanceUtil(value);",this);
    }

    public boolean getUseConvexConservativeDistanceUtil() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalBoolean("jsObj.get_m_useConvexConservativeDistanceUtil();",this);
    }

    public void setConvexConservativeDistanceThreshold(float value) {
		com.dragome.commons.javascript.ScriptHelper.put("value",value,this);
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		com.dragome.commons.javascript.ScriptHelper.evalNoResult("jsObj.set_m_convexConservativeDistanceThreshold(value);",this);
    }

    public float getConvexConservativeDistanceThreshold() {
		checkPointer();
		com.dragome.commons.javascript.ScriptHelper.put("jsObj",this.jsObj,this);
		return com.dragome.commons.javascript.ScriptHelper.evalFloat("jsObj.get_m_convexConservativeDistanceThreshold();",this);
    }
}