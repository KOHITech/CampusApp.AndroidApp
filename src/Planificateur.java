import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Planificateur {
	public Task[] PlanAweek(User me, Week w0, Task[] tasks){
		//this method sorts the tasks by deadline
		int len = tasks.length;
		Calendar fd = w0.first_day;
		List<Integer[]> T = new ArrayList<Integer[]>(len);
		for(int i=0; i<len; i++){
			Integer[] pT = new Integer[2];
			int marge = getMarge(fd, tasks[i]);
			pT[0] = marge;
			pT[1] = tasks[i].id;
			T.add(pT);
		}
		for(int i=1; i<len; i++){
			int p=i;
			int m = T.get(i)[0];
			for(int j=i-1; j<len; j++){
				if(T.get(j)[0]<m){
					p=j;
					m=T.get(j)[0];
				}
			}
			if(p!=i){
				Integer a = T.get(p)[0];
				Integer b = T.get(p)[1];
				T.get(p)[0] = T.get(i)[0];
				T.get(p)[1] = T.get(i)[1];
				T.get(i)[0] = a;
				T.get(i)[1] = b;
			}
		}
		//Now we will build a list T2 where we will add a third attribute : priority
		List<Integer[]> T2 = new ArrayList<Integer[]>(len);
		for(int i=0; i<len; i++){
			Integer[] pT = new Integer[3];
			pT[0] = T.get(i)[0];
			pT[1] = T.get(i)[1];
			int priority_i = 0;
			for(int k=0;k<len;k++){
				if (tasks[k].id == pT[1]){
					priority_i = (int) tasks[k].prio;
				}
			}
			int pu = priority_i;
			pT[2] = pu;
			T.add(pT);
		}
		//Now we will build a list L where tasks of identical deadlines will be sorted by priority
		List<Integer[]> L = new ArrayList<Integer[]>(len);
		Integer[] pL = new Integer[3];
		for(int i=0;i<len;i++){
			L.add(pL);
		}
		// T2 is now a matrix of size : (len,3) with the columns (deadline_margin,id,priority)
		for(int i=0; i<len; i++){
			int[] a = null;
			for(int j=0;j<len;j++){
				a[j] = getDeadline_day(T2.get(j)[1],j,tasks,T2);
			}
			for(int j=i;j<len;j++){
				List<Integer[]> K = new ArrayList<Integer[]>();
				int c = 0;
				int p=j;
				while(a[i] == a[p]){
					Integer[] pK = new Integer[3];
					pK[0] = T.get(p)[0];
					pK[1] = T.get(p)[1];
					pK[2] = T.get(p)[2];
					K.add(pK);
					c+=1;
					p+=1;
				}
				if(a[i] != a[j]){
					Integer[] t = new Integer[3];
					t[0] = T.get(j)[0];
					t[1] = T.get(j)[1];
					t[2] = T.get(j)[2];
					L.add(t);
				}
				for(int k=0;k<c;k++){
					for(int s=i+1;s<c;s++){
						if(K.get(k)[2]<K.get(p)[2]){
							Integer o = K.get(k)[0];
							Integer b = K.get(k)[1];
							Integer e = K.get(k)[2];
							K.get(k)[0] = K.get(s)[0];
							K.get(k)[1] = K.get(s)[1];
							K.get(k)[2] = K.get(s)[2];
							K.get(s)[0] = o;
							K.get(s)[1] = b;
							K.get(s)[2] = e;
						}
					}
				}
				L.addAll(K);
			}
		}
		// L is now a 3 dimensional (margin,id,priority) list where tasks are sorted by margin to deadline
		// and by priority
		// All that is left to do now is to convert this list L to a list of tasks (Task[])
		// which is simple because we have the id of each task
		Task[] finale = null;
		int count = 0;
		for(int i=0;i<len;i++){
			int id_i = L.get(i)[1];
			for (int n=0;n<len;n++){
				if(tasks[n].id == id_i){
					finale[count] = tasks[n];
					count += 1;
				}
			}
		}
		return finale;
	}
	
	public int getDeadline_day(int id,int i,Task[] tasks, List<Integer[]> T2){
		Calendar deadline_i = null;
		for(int k=0;k<tasks.length;k++){
			if(tasks[k].id == T2.get(i)[1]){
				deadline_i = tasks[k].date;
			}
		}
		int day = deadline_i.DATE;
		return day;
	}
	
	
	private int getMarge(Calendar fd, Task task){
		Calendar date2 = task.date;
		int a = fd.compareTo(date2);
		return a;
	}

}
