package com.adb_music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MusicService extends Service {
    private MediaPlayer player;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public  void seekToPosition(int position){
        player.seekTo(position);
    }
    public void playMusic() {
        System.out.println("播放");


        try {
            player.reset();
            player.setDataSource("/Recorder/aa.mp3");
            player.prepare();
            player.start();
            updateSeeBar();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void updateSeeBar() {
        final int duration=player.getDuration();
        final Timer timer =new Timer();
        final TimerTask timerTask =new TimerTask() {
            @Override
            public void run() {
         int currentPosition=player.getCurrentPosition();
                Message msg =Message.obtain();
                Bundle budle= new Bundle();
                budle.putInt("duration",duration);
                budle.putInt("currentPosition",currentPosition);
                msg.setData(budle);
                MainActivity.handler.sendMessage( msg);
            }
        };
        timer.schedule(timerTask,300,1000);
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                System.out.println("歌曲播放完了");
                timer.cancel();
                timerTask.cancel();
            }
        });
    }

    public void pauseMusic(){
        System.out.println("暂停");
        player.pause();
    } public void rePlayMusic(){
        System.out.println("重播");
        player.start();
    }

    private  class  Mybinder extends Binder implements  Iservice{

        @Override
        public void callPlayMusic() {
            playMusic();
        }

        @Override
        public void callPauseMusic() {
        pauseMusic();
        }

        @Override
        public void callRePlayMusic() {
        rePlayMusic();
        }

        @Override
        public void callSeekToPosition(int progress) {
        seekToPosition(progress);
        }
    }


}
