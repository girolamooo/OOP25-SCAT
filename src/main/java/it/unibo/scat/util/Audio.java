package it.unibo.scat.util;

/**
 * ...
 * 
 */
public interface Audio {

    /**
     * ...
     * 
     * @param audioTrack ...
     * @param loop       ...
     */
    void play(AudioTrack audioTrack, boolean loop);

    /**
     * ...
     * 
     */
    public void stop();

    /**
     * ...
     * 
     * @param volume ...
     */
    public void setVolume(float volume);

}
