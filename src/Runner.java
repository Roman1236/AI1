import java.util.ArrayList;
import java.util.Stack;

public class Runner {

public  static int max_depth = 20;
public static ArrayList <State> state_list = new ArrayList<>();

   static State goal = new State(0,0,3,3,0,0,true,false);
   static State temp_state =  new State();
   static ArrayList <State> right_way = new ArrayList<>();

    public static void main(String []args){

    State state = new State(3, 3, 0, 0, 0, 0, false,false);

        DLS(0);
        printPath(temp_state);


for(int i= right_way.size()-1; i>=0; i--) {
    System.out.print(right_way.get(i).getLeftBankMis()+"  ");
    System.out.print(right_way.get(i).getLeftBankCan()+"  ");
    System.out.print(right_way.get(i).getBoatMis()+"  ");
    System.out.print(right_way.get(i).getBoatCan()+"  ");
    System.out.print(right_way.get(i).getRightBankMis()+"  ");
    System.out.print(right_way.get(i).getRightBankCan()+"  ");
    System.out.print(right_way.get(i).getBoatSide()+"  ");
    System.out.println("");
}

    }

    public static State DLS(int depth) {
        Stack<State> stack = new Stack<State>();
        stack.push(new State(3, 3, 0, 0, 0, 0, false,false,0));

        while(!stack.empty()) {
            State cur = stack.pop();
            if (cur.equals(goal)) {
                return cur;
            }
            if(depth > max_depth) {
                continue;
            }
            cur.setDpth(cur.getDpth()+1);
            findChildState(cur, stack, goal);
        }
        return null;
    }

    public static State findChildState(State state,Stack stack, State goal){

        State tmp1 = new State(state.getLeftBankMis(),state.getLeftBankCan(),state.getRightBankMis(),state.getRightBankCan(),state.getBoatMis(),state.getBoatCan(),state.getBoatSide(),state.getB_in_out());
        State tmp2 = new State(state.getLeftBankMis(),state.getLeftBankCan(),state.getRightBankMis(),state.getRightBankCan(),state.getBoatMis(),state.getBoatCan(),state.getBoatSide(),state.getB_in_out());
        State tmp3 = new State(state.getLeftBankMis(),state.getLeftBankCan(),state.getRightBankMis(),state.getRightBankCan(),state.getBoatMis(),state.getBoatCan(),state.getBoatSide(),state.getB_in_out());
        State tmp4 = new State(state.getLeftBankMis(),state.getLeftBankCan(),state.getRightBankMis(),state.getRightBankCan(),state.getBoatMis(),state.getBoatCan(),state.getBoatSide(),state.getB_in_out());
        State tmp5 = new State(state.getLeftBankMis(),state.getLeftBankCan(),state.getRightBankMis(),state.getRightBankCan(),state.getBoatMis(),state.getBoatCan(),state.getBoatSide(),state.getB_in_out());
        tmp1.setPrevious(state);
        tmp2.setPrevious(state);
        tmp3.setPrevious(state);
        tmp4.setPrevious(state);
        tmp5.setPrevious(state);

        if(state.getBoatSide()==false){
            if(state.getB_in_out()==false){
                if(tmp1.getLeftBankCan()>=2){tmp1.move2c_lb(tmp1); tmp1.setBoatSide(true);  tmp1.setB_in_out(true); if(new_node(tmp1)){ state_list.add(tmp1);  if(tmp1.check_node(tmp1)){ temp_state=tmp1; stack.push(tmp1);}}}
                if(tmp2.getLeftBankCan()>=1){tmp2.move1c_lb(tmp2); tmp2.setBoatSide(true);  tmp2.setB_in_out(true);  if(new_node(tmp2)){state_list.add(tmp2);  if(tmp2.check_node(tmp2)){ temp_state=tmp2; stack.push(tmp2);}}}
                if(tmp3.getLeftBankMis()>=2){tmp3.move2m_lb(tmp3); tmp3.setBoatSide(true);  tmp3.setB_in_out(true);  if(new_node(tmp3)){state_list.add(tmp3);  if(tmp3.check_node(tmp3)){ temp_state=tmp3; stack.push(tmp3);}}}
                if(tmp4.getLeftBankMis()>=1){tmp4.move1m_lb(tmp4); tmp4.setBoatSide(true);  tmp4.setB_in_out(true);  if(new_node(tmp4)){ state_list.add(tmp4); if(tmp4.check_node(tmp4)){ temp_state=tmp4; stack.push(tmp4);}}}
                if(tmp5.getLeftBankCan()>=1&&tmp5.getLeftBankMis()>=1){tmp5.move1c1m_lb(tmp5); tmp5.setBoatSide(true);  tmp5.setB_in_out(true);  if(new_node(tmp5)){state_list.add(tmp5);  if(tmp5.check_node(tmp5)){  temp_state=tmp5; stack.push(tmp5);}}}
            }else{
                tmp1.moveAll_bl(tmp1); tmp1.setB_in_out(false);  if(new_node(tmp1)){ state_list.add(tmp1); temp_state=tmp1;  stack.push(tmp1);}
            }
        }else {
            if(state.getB_in_out()==false){
                if(tmp1.getRightBankCan()>=2){tmp1.move2c_rb(tmp1); tmp1.setBoatSide(false);  tmp1.setB_in_out(true);   if(new_node(tmp1)){ state_list.add(tmp1);  if(tmp1.check_node(tmp1)){  temp_state=tmp1; stack.push(tmp1);}}}
                if(tmp2.getRightBankCan()>=1){tmp2.move1c_rb(tmp2); tmp2.setBoatSide(false);  tmp2.setB_in_out(true);   if(new_node(tmp2)){ state_list.add(tmp2);  if(tmp2.check_node(tmp2)){  temp_state=tmp2; stack.push(tmp2);}}}
                if(tmp3.getRightBankMis()>=2){tmp3.move2m_rb(tmp3); tmp3.setBoatSide(false);  tmp3.setB_in_out(true);   if(new_node(tmp3)){ state_list.add(tmp3);  if(tmp3.check_node(tmp3)){  temp_state=tmp3; stack.push(tmp3);}}}
                if(tmp4.getRightBankMis()>=1){tmp4.move1m_rb(tmp4); tmp4.setBoatSide(false);  tmp4.setB_in_out(true);   if(new_node(tmp4)){ state_list.add(tmp4);  if(tmp4.check_node(tmp4)){  temp_state=tmp4; stack.push(tmp4);}}}
                if(tmp5.getRightBankCan()>=1&&tmp5.getRightBankMis()>=1){tmp5.move1c1m_rb(tmp5); tmp5.setBoatSide(false);  tmp5.setB_in_out(true);  if(new_node(tmp5)){ state_list.add(tmp5);  if(tmp5.check_node(tmp5)){  if(tmp5.equals(goal)){temp_state=tmp5;}  stack.push(tmp5);}}}
            }else {
                tmp1.moveAll_br(tmp1); tmp1.setB_in_out(false);  if(new_node(tmp1)){ state_list.add(tmp1);  if(tmp1.equals(goal)){temp_state=tmp1;right_way.add(tmp1);}  stack.push(tmp1);}
            }
        }
        return state;
    }

    public static boolean new_node(State s){

        for(int i=0;i<state_list.size();i++)
        {
            if(s.equals(state_list.get(i))){ return false;}
        }
        return true;
    }

    public static void printPath(State state) {
        State cur = state;

        while (cur.getPrevious() != null) {
            cur = cur.getPrevious();
            right_way.add(cur);
        }
    }

}























