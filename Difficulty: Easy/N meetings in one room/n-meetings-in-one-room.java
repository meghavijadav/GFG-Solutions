//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) end[i] = Integer.parseInt(inputLine[i]);

            int ans = new Solution().maxMeetings(n, start, end);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    class Meeting {
        int start;
        int end;
        int pos;
     
        Meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    class MeetingComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting m1, Meeting m2) {
            if (m1.end < m2.end) return -1;
            else if (m1.end > m2.end) return 1;
            else return Integer.compare(m1.pos, m2.pos);
        }
    }

    
    public int maxMeetings(int n, int start[], int end[]) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
            meetings.add(new Meeting(start[i], end[i], i + 1));
        
        Collections.sort(meetings, new MeetingComparator()); 
        
        int limit = meetings.get(0).end; 
        int count = 1; 
        
        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > limit) {
                limit = meetings.get(i).end; 
                count++;
            }
        }

        return count;
    }
}

