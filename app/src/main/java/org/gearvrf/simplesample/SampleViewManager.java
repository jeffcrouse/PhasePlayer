/* Copyright 2015 Samsung Electronics Co., LTD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gearvrf.simplesample;

import android.graphics.Color;


import java.util.ArrayList;
import java.util.List;

import org.gearvrf.GVRAndroidResource;
import org.gearvrf.GVRCameraRig;
import org.gearvrf.GVRContext;
import org.gearvrf.GVRMesh;
import org.gearvrf.GVRPostEffect;
//import org.gearvrf.GVRRenderData.GVRRenderMaskBit;
import org.gearvrf.GVRScene;
import org.gearvrf.GVRSceneObject;
import org.gearvrf.GVRScript;
//import org.gearvrf.GVRTexture;
import org.gearvrf.animation.GVRAnimation;
import org.gearvrf.animation.GVRAnimationEngine;
//import org.gearvrf.animation.GVROpacityAnimation;
//import org.gearvrf.animation.GVRRotationByAxisWithPivotAnimation;
//import org.gearvrf.animation.GVRScaleAnimation;
import org.gearvrf.scene_objects.GVRVideoSceneObject;
import org.gearvrf.scene_objects.GVRVideoSceneObject.GVRVideoType;

import android.media.MediaPlayer;

public class SampleViewManager extends GVRScript {

    private GVRContext mGVRContext = null;

    @Override
    public void onInit(GVRContext gvrContext) {


        mGVRContext = gvrContext;

        GVRScene scene = gvrContext.getNextMainScene();
        GVRScene mainScene = mGVRContext.getNextMainScene();
        GVRCameraRig mainCameraRig = scene.getMainCameraRig();


        mainCameraRig.getLeftCamera()
                .setBackgroundColor(Color.BLACK);
        mainCameraRig.getRightCamera()
                .setBackgroundColor(Color.BLACK);

        mainScene.getMainCameraRig().getTransform()
                .setPosition(0.0f, 0.0f, 0.0f);

        GVRMesh sphereMesh = mGVRContext.loadMesh(new GVRAndroidResource(
                mGVRContext, R.raw.sphere_mesh));


        MediaPlayer mediaPlayer = MediaPlayer.create(mGVRContext.getContext(), R.drawable.three);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        GVRVideoSceneObject video = new GVRVideoSceneObject(mGVRContext,sphereMesh, mediaPlayer, GVRVideoType.MONO);
        video.setName("video");

        mainScene.addSceneObject(video);
    }

    @Override
    public void onStep() {

    }

}
