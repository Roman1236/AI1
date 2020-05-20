public class State {
    private int leftBankMis;
    private int leftBankCan;
    private int rightBankMis;
    private int rightBankCan;
    private int boatMis;
    private int boatCan;
    private boolean boat;
    private State previous;
    private boolean boat_passangers_last_move;

    public boolean getB_in_out() {
        return boat_passangers_last_move;
    }

    public void setB_in_out(boolean B_in_out) {
        this.boat_passangers_last_move = B_in_out;
    }

    public State() {
    }

    public State(int leftBankMis, int leftBankCan, int rightBankMis, int rightBankCan, int boatMis, int boatCan, boolean boat, boolean boat_passangers_last_move,int dpth) {
        this.leftBankMis = leftBankMis;
        this.leftBankCan = leftBankCan;
        this.rightBankMis = rightBankMis;
        this.rightBankCan = rightBankCan;
        this.boatMis = boatMis;
        this.boatCan = boatCan;
        this.boat = boat;
        this.boat_passangers_last_move = boat_passangers_last_move;
        this.dpth=dpth;
    }
    public State(int leftBankMis, int leftBankCan, int rightBankMis, int rightBankCan, int boatMis, int boatCan, boolean boat, boolean boat_passangers_last_move) {
        this.leftBankMis = leftBankMis;
        this.leftBankCan = leftBankCan;
        this.rightBankMis = rightBankMis;
        this.rightBankCan = rightBankCan;
        this.boatMis = boatMis;
        this.boatCan = boatCan;
        this.boat = boat;
        this.boat_passangers_last_move = boat_passangers_last_move;
    }

    private int dpth;

    public int getDpth() {
        return dpth;
    }

    public void setDpth(int dpth) {
        this.dpth = dpth;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if (!(o instanceof State)) {
            return false;
        }
        State s = (State) o;

        return leftBankMis==s.leftBankMis&&
               leftBankCan==s.leftBankCan&&
               rightBankMis==s.rightBankMis&&
               rightBankCan==s.rightBankCan&&
               boatMis==s.boatMis&&
               boatCan==s.boatCan&&
               boat==s.boat;

    }
    public State getPrevious() {
        return previous;
    }

    public void setPrevious(State previous) {
        this.previous = previous;
    }

    public int getRightBankMis() {
        return rightBankMis;
    }

    public void setRightBankMis(int rightBankMis) {
        this.rightBankMis = rightBankMis;
    }

    public int getRightBankCan() {
        return rightBankCan;
    }

    public void setRightBankCan(int rightBankCan) {
        this.rightBankCan = rightBankCan;
    }

    public int getBoatMis() {
        return boatMis;
    }

    public void setBoatMis(int boatMis) {
        this.boatMis = boatMis;
    }

    public int getBoatCan() {
        return boatCan;
    }

    public void setBoatCan(int boatCan) {
        this.boatCan = boatCan;
    }

    public boolean getBoatSide() {
        return boat;
    }

    public void setBoatSide(boolean boat) {
        this.boat = boat;
    }

    public int getLeftBankMis() {
        return leftBankMis;
    }

    public void setLeftBankMis(int leftBankMis) {
        this.leftBankMis = leftBankMis;
    }

    public int getLeftBankCan() {
        return leftBankCan;
    }

    public void setLeftBankCan(int leftBankCan) {
        this.leftBankCan = leftBankCan;
    }




    public void move2c_lb(State obj){
        obj.leftBankCan -= 2;
        obj.boatCan +=2;
    }
    public void move2m_lb(State obj){
        obj.leftBankMis -= 2;
        obj.boatMis +=2;
    }
    public void move1c1m_lb(State obj){
        obj.leftBankCan -=1;
        obj.leftBankMis -=1;
        obj.boatCan +=1;
        obj.boatMis +=1;
    }
    public void move1c_lb(State obj){
        obj.leftBankCan -=1;
        obj.boatCan +=1;
    }
    public void move1m_lb(State obj){
        obj.leftBankMis -=1;
        obj.boatMis +=1;
    }
//

    public void move2c_rb(State obj){
        obj.rightBankCan -= 2;
        obj.boatCan +=2;
    }
    public void move2m_rb(State obj){
        obj.rightBankMis -= 2;
        obj.boatMis +=2;
    }
    public void move1c1m_rb(State obj){
        obj.rightBankCan -=1;
        obj.rightBankMis -=1;
        obj.boatCan +=1;
        obj.boatMis +=1;
    }
    public void move1c_rb(State obj){
        obj.rightBankCan -=1;
        obj.boatCan +=1;
    }
    public void move1m_rb(State obj){
        obj.rightBankMis -=1;
        obj.boatMis +=1;
    }
 //

    public void move2c_bl(State obj){
        obj.boatCan -=2;
        obj.leftBankCan +=2;
    }
    public void move2m_bl(State obj){
        obj.boatMis -=2;
        obj.leftBankMis +=2;
    }
    public void move1c1m_bl(State obj){
        obj.boatCan -=1;
        obj.boatMis -=1;
        obj.leftBankCan +=1;
        obj.leftBankMis +=1;
    }
    public void move1c_bl(State obj){
        obj.boatCan -=1;
        obj.leftBankCan +=1;
    }
    public void move1m_bl(State obj){
        obj.boatMis -=1;
        obj.leftBankMis +=1;
    }

//

    public void move2c_br(State obj){
        obj.boatCan -=2;
        obj.rightBankCan +=2;
    }
    public void move2m_br(State obj){
        obj.boatMis -=2;
        obj.rightBankMis +=2;
    }
    public void move1c1m_br(State obj){
        obj.boatCan -=1;
        obj.boatMis -=1;
        obj.rightBankCan +=1;
        obj.rightBankMis +=1;
    }
    public void move1c_br(State obj){
        obj.boatCan -=1;
        obj.rightBankCan +=1;
    }
    public void move1m_br(State obj){
        obj.boatMis -=1;
        obj.rightBankMis +=1;
    }

/////////////////////////

    public void moveAll_bl(State obj){
        obj.leftBankCan+=obj.boatCan;
        obj.boatCan=0;
        obj.leftBankMis+=obj.boatMis;
        obj.boatMis=0;
    }

    public void moveAll_br(State obj){
        obj.rightBankCan+=obj.boatCan;
        obj.boatCan=0;
        obj.rightBankMis+=obj.boatMis;
        obj.boatMis=0;
    }


    public boolean check_node(State obj){
 if(obj.leftBankMis == 0 || obj.leftBankCan == 0){
     if(obj.rightBankMis == obj.rightBankCan){return true;}
 }
 if(obj.rightBankMis == 0 || obj.rightBankCan == 0){
     if(obj.leftBankMis == obj.leftBankCan){return true;}
 }
 if(obj.leftBankMis==obj.leftBankCan && obj.rightBankMis==obj.rightBankCan){return true;}
 if(obj.leftBankMis == 0){
     if(obj.rightBankCan==0){return true;}
 }
 if(obj.leftBankCan==0){
     if(obj.rightBankMis==0){return true;}
 }

return false;

    }






}
