// IMusicPlayer.aidl
package com.jascal.galatea;


interface IMusicPlayer {
    void play(in String uri);

    boolean isPlaying();

    int getDuration();

    int getCurrentPosition();

    void seekTo(in int position);
}
