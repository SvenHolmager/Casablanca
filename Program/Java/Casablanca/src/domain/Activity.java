/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Mads
 */
public class Activity
{
   private String sport;
   private int time;
   private int participants;
   
   public Activity (String sport, int time,int participants){
       this.sport = sport;
       this.time = time;
       this.participants = participants;
   }

    public void setSport(String sport)
    {
        this.sport = sport;
    }

    public void setTime(int time)
    {
        this.time = time;
    }

    public void setParticipants(int participants)
    {
        this.participants = participants;
    }

    public String getSport()
    {
        return sport;
    }

    public int getTime()
    {
        return time;
    }

    public int getParticipants()
    {
        return participants;
    }
           
           
           
}
