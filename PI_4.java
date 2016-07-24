import java.util.*;


public class PI_4
{
   public static void main(String[] args) 
	{
             HiCal cal = new HiCal();
             ArrayList<Meeting> ListOfMeetings = new ArrayList<Meeting>();
             ListOfMeetings.add(new Meeting(0,1));
             ListOfMeetings.add(new Meeting(3,5));
   //        ListOfMeetings.add(new Meeting(2,4));
             ListOfMeetings.add(new Meeting(9,10));
             List<Meeting> result =  cal.getCondensedMeetings(ListOfMeetings);
           
            for(Meeting m : result) System.out.println( "Start Time : "+ m.startTime + " EndTime : " + m.endTime);
	}

}


class Meeting
{
  
   int startTime;
   int endTime;

public Meeting(int start , int end)
  {
     startTime = start;
     endTime = end;
  }

}



class HiCal
{

    List<Meeting> getCondensedMeetings(ArrayList<Meeting> meetingList)
	{

             if(meetingList.size() < 2) return meetingList;
             Collections.sort(meetingList, new RangeSorter());
             List<Meeting> res = new ArrayList<Meeting>();       
 
             Meeting lastMeeting;
             lastMeeting = meetingList.get(0);
             Meeting curMeeting = null;
           
             for(int i=1; i < meetingList.size(); i++)
             {
                curMeeting = meetingList.get(i); 
               	int start, end;
                
		if(curMeeting.startTime <= lastMeeting.endTime) 
               {
                  start = Math.min(lastMeeting.startTime, curMeeting.startTime);
                  end  = Math.max(lastMeeting.endTime, curMeeting.endTime);   
                  lastMeeting = new Meeting(start,end);
               }
               else
	       {
                   System.out.println("###" + lastMeeting.endTime);
                   res.add(lastMeeting);
                   lastMeeting = curMeeting;                  
               }
            } 
            if(curMeeting != null) res.add(lastMeeting);
           
           return res;      
	}

}




class RangeSorter implements Comparator<Meeting>
{
  @Override
  public int compare(Meeting m1, Meeting m2)
	{
           return (m1.startTime - m2.startTime);
        }
}
