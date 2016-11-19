import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Planificateur2 extends Planificateur{
	
	//Cette algorithme fait l'hypothèse que les tâches définies par l'admin (week0) sont de priorité 4

	public Task PlanAmeeting(User[] users,int week_id,int priority){
		//Takes all members' schedules and gives a potential common slot for the meeting
		//If the method doesn't find a slot, it tells the users to negotiate
		int members_num = users.length;
		List<Task> M = new ArrayList<Task>();
		//la liste des tâches des users est de la même longueur (tous les créneaux y inclus les vides)
		int n = users[0].weeks[week_id].tasks.length;
		for(int i=0;i<members_num;i++){
			for(int j=0;j<n;j++){
				Task task_j_user_i = users[i].weeks[week_id].tasks[j];
				M.add(task_j_user_i);
			}
		}
		int N = M.size();
		//Avant de passer à l'algorithme qui trouve le créneau commun, créons d'abord une liste qui ne contient 
		//que les créneaux "possibles" (ceux de priorité 4 et ceux exprimés dans les contraintes générales
		
		List<Date[][]> P2 = new ArrayList<Date[][]>();
		//P2 va contenir l'ensemble des contraintes générales des membres du groupe (type Date[][])
		for(int k=0;k<members_num;k++){
			P2.add(users[k].gc.timespan2);
		}
		Task reunion = null;
		boolean flag1 = true;
		boolean flag2 = true;
		for(int s=0;s<4;s++){
			if(flag1 == true){
				for (int i=0;i<n;i++){
					if(M.get(i).prio == M.get(i+n).prio && M.get(i+n).prio ==M.get(i+2*n).prio && M.get(i+2*n).prio ==M.get(i+3*n).prio && M.get(i+3*n).prio == s && flag2 == true){
						assert (P2.contains(M.get(i).c.timespan2) == false);
						assert (P2.contains(M.get(i+n).c.timespan2) == false);
						assert (P2.contains(M.get(i+2*n).c.timespan2) == false);
						assert (P2.contains(M.get(i+3*n).c.timespan2) == false);
						reunion.creneau = M.get(i).creneau;
						reunion.prio = priority;
						flag1 = false;
						flag2 = false;
					}
				}
			}
		}
		if(reunion == null){
			System.out.println("Négociez entre vous un créneau !");
		}
		return reunion;
	}

}
