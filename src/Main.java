import java.util.*;
class Players{
    static int[] playerScores,systemScores;
    static String[] playerNames,systemNames;
    static int now,index=0,sIndex=0,finalWicket,sysWicket;
    static boolean flag;
    protected static void print(String a,int b){
        System.out.print(a);
        for(int i=a.length();i<=20;i++)
            System.out.print(' ');
        System.out.println(b);
    }
    protected static void addName(Scanner sc){
        System.out.println("Player Name :");
        playerNames[index]=sc.next();
        flag=false;
        System.out.println("Bat:");
    }
    protected static void addScore(int score){
        System.out.println("Player Score :"+score);
        playerScores[index]=score;
        index++;
    }
    protected static void sysName(){
        systemNames[sIndex]="System "+(sIndex+1);
        System.out.println("Player Name : "+systemNames[sIndex]);
        flag=false;
        System.out.println("Bowl:");
    }
    protected static void sysScore(int score){
        System.out.println("Player Score :"+score);
        systemScores[sIndex]=score;
        sIndex++;
    }
}
class HandCricket extends Players{
    static int  toss, inning, target, in1 = 0, in2 = 0;
    static boolean toss_sts, res;

    public static void play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of wickets");
        now = sc.nextInt();
        playerNames=new String[now];
        playerScores=new int[now];
        systemScores=new int[now];
        systemNames=new String[now];
        System.out.println("Toss");
        System.out.println("\t1.Head\t2.Tail");
        Random r = new Random();
        tossing(sc, r);
        inning1(sc, r);
        System.out.println("Target : "+target);
        inning2(sc, r);
        result();
    }

    private static void batting(Scanner sc, Random r) {
        int cw = now, ball, bat;
        System.out.println("Inning 1: You are Batiing");
        flag=true;
        int score=0;
        while (cw > 0) {
            if(flag)
                addName(sc);
            ball = r.nextInt(6) + 1;
            ball=7-ball;
            boolean f=true;
            while(f) {
                try {
                    String b=sc.next();
                    bat = Integer.parseInt(b);
                    if(bat<1||bat>6)
                        throw new IllegalAccessException();
                    f=false;
                    System.out.println(bat + "    " + ball);
                    if (ball == bat) {
                        System.out.println("Out\t remaining wickets :" + --cw);
                        flag = true;
                        addScore(score);
                        score = 0;
                    } else {
                        in1 += bat;
                        score += bat;
                    }
                    System.out.println();
                }
                catch(IllegalAccessException e){
                    System.out.println("Enter a valid score\n");
                }
                catch(Exception e){
                    System.out.println("Skip it");
                    f=false;
                }
            }
        }
        System.out.println("Your score " + in1);
    }

    private static void batting(Scanner sc, Random r, int tr) {
        int cw = now, ball, bat;
        System.out.println("Inning 2: You are Batiing");
        flag =true;
        int score=0;
        while (cw > 0 && in2 <= target) {
            if(flag)
                addName(sc);
            ball = r.nextInt(6) + 1;
            ball=7-ball;
            boolean f=true;
            while(f) {
                try {
                    String b=sc.next();
                    bat = Integer.parseInt(b);
                    if(bat>6||bat<1)
                        throw new IllegalAccessException();
                    f=false;
                    System.out.println(bat + "    " + ball);
                    if (ball == bat) {
                        System.out.println("Out\t remaining wickets :" + --cw+"   needed "+(target-in2));
                        flag = true;
                        addScore(score);
                        score = 0;
                    } else {
                        in2 += bat;
                        score += bat;
                        if (in2 > target)
                            addScore(score);
                    }
                    System.out.println();
                }
                catch(IllegalAccessException e){
                    System.out.println("Enter a valid score\n");
                }
                catch(Exception e){
                    System.out.println("Skip it");
                    f=false;
                }
            }
        }
        System.out.println("Your score " + in2);
    }

    private static void bowling(Scanner sc, Random r) {
        System.out.println("Inning 1: You are Bowling");
        int cw = now, ball, bat;
        flag=true;
        int score=0;
        while (cw > 0) {
            if(flag){
                sysName();
            }
            boolean f=true;
            while(f) {
               try {
                   String b=sc.next();
                    ball = Integer.parseInt(b);
                    if(ball>6||ball<1)
                        throw new IllegalAccessException();
                    f=false;
                    bat = r.nextInt(6) + 1;
                    System.out.println(ball + "    " + bat);
                    if (ball == bat) {
                        System.out.println("Out\t remaining wickets :" + --cw);
                        flag = true;
                        sysScore(score);
                        score = 0;
                    } else {
                        in1 += bat;
                        score += bat;
                    }
                    System.out.println();
                }
               catch(IllegalAccessException e){
                   System.out.println("Enter a valid Ball\n");
               }
               catch(Exception e){
                   System.out.println("Skip it");
                   f=false;
               }
            }
        }
        System.out.println("System score " + in1);
    }

    private static void bowling(Scanner sc, Random r, int tr) {
        int cw = now, ball, bat;
        flag=true;
        int score=0;
        System.out.println("Inning 2: You are Bowling");
        while (cw > 0 && in2 <= target) {
            if(flag)
                sysName();
            boolean f=true;
            while(f) {
                try{
                    String b=sc.next();
                    ball = Integer.parseInt(b);
                    if(ball>6||ball<1)
                        throw new IllegalAccessException();
                    f=false;
                    bat = r.nextInt(6) + 1;
                    System.out.println(ball + "    " + bat);
                    if (ball == bat) {
                        System.out.println("Out\t remaining wickets :" + --cw+"   needed "+ (target-in2));
                        sysScore(score);
                        flag = true;
                        score = 0;
                    } else {
                        in2 += bat;
                        score += bat;
                        if (in2 > target) {
                            sysScore(score);
                        }
                    }
                    System.out.println();
                }
                catch(IllegalAccessException e){
                    System.out.println("Enter a valid Ball\n");
                }
                catch(Exception e){
                    System.out.println("Skip it");
                    f=false;
                }
            }
        }
        System.out.println("System score " + in2);
    }

    private static void inning1(Scanner sc, Random r) {

        switch (inning) {
            case 1:
                batting(sc, r);
                break;
            case 2:
                bowling(sc, r);
                break;
        }
        target = in1 + 1;
    }

    private static void inning2(Scanner sc, Random r) {
        switch (inning) {
            case 2:
                batting(sc, r, target);
                break;
            case 1:
                bowling(sc, r, target);
                break;
        }
    }

    private static void result() {
        int score_1=0,score_2=0;
        switch (inning) {
            case 1:
                if (in2 >= target)
                    res = false;
                else
                    res = true;
                break;
            case 2:
                if (in2 >= target)
                    res = true;
                else
                    res = false;
                break;
        }
        if (res)
            System.out.println("You have won the Match!!");
        else
            System.out.println("You have lose the Match!!");
        System.out.println("System Score Card");
        for(int i=0;i<sIndex;i++){
            System.out.println(systemNames[i]+"    "+systemScores[i]);
            score_1+=systemScores[i];
        }
        System.out.println("Total     "+score_1);
        System.out.println("Your Score Card");
        for(int i=0;i<index;i++){
            print(playerNames[i],playerScores[i]);
            score_2+=playerScores[i];
        }
        System.out.println("Total     "+score_2);
    }
    protected static void tossing(Scanner sc, Random r) {
        flag=true;
        while(flag){
            try {
                String tos=sc.next();
                toss = Integer.parseInt(tos);
                if(toss!=2&&toss!=1)
                    throw new IllegalAccessException();
                flag=false;
            }
            catch(IllegalAccessException e){
                System.out.println("Enter a valid option");
            }
            catch(Exception e){
                System.out.println("Skip it");
            }
        }
        int ts = r.nextInt(2) + 1;
        toss_sts = toss == ts;
        if (toss_sts) {
            System.out.println("Congrats ! You hava won the Toss !!");
            System.out.println("\t1.Bat\t2.Bowl");
            flag=true;
            while(flag) {
                try {
                    String inni=sc.next();
                    inning = Integer.parseInt(inni);
                    if (inning != 1 &&inning != 2)
                        throw new IllegalAccessException();
                    flag = false;
                }
                catch(IllegalAccessException e){
                    System.out.println("Enter a valid option");
                }
                catch(Exception e){
                    System.out.println("Skip it");
                    return;
                }
            }
        } else {
            System.out.println("System has won the toss");
            if (r.nextInt(2) == 0) {
                System.out.println("Chooses to BAT first");
                inning = 2;
            } else {
                System.out.println("Chooses to BOWL");
                inning = 1;
            }
        }
    }
}
class OverMatch extends HandCricket{
    static int[] ballFaced,sysFaced,ballWickets,ballOvers,bowlBalls,bowlRuns,sbWickets,sbOvers,sbBalls,sbRuns;
    static int overs,eOver=0,eBall=0,sOver=0,sBall=0;
    static double[] points,sPoints;
    static final int[] batSysProb;

    static {
        batSysProb = new int[]{3, 5, 5, 6, 0, 0, 6, 1, 2, 3, 1, 3, 6, 5, 3, 5, 4, 5, 0, 5, 1, 2, 6, 0, 1, 2, 3, 6, 4, 1, 2, 4, 0, 3, 4};
    }

    static final int[] balSysProb;
    static {
        balSysProb = new int[]{5,2,3,6,4,1,1,6,3,5,6,6,4,6,5,1,4,5,3,2,6,5,4,3,4,5,6};
    }
    static protected void dispOver(int a,int b){
        String c="";
        if(a!=0)
            c="Need "+a;
        switch (b){
            case 1:
                System.out.println(eOver+"."+eBall+" "+c);
                break;
            case 2:
                System.out.println(sOver+"."+sBall+" "+c);
        }
    }
    static protected void dispOver(int a,int b,int c,int e){
        String d="";
        if(a!=0)
            d+="Need "+a;
        switch (b){
            case 1:
                System.out.println(c+"/"+(now-e)+" "+eOver+"."+eBall+" "+d);
                break;
            case 2:
                System.out.println(c+"/"+(now-e)+" "+sOver+"."+sBall+" "+d);
        }
    }
    static final int balsize=balSysProb.length;
    static final int batsize=batSysProb.length;
    protected static void addBall(int b){
        ballFaced[index]=b;
    }
    protected static void sysBall(int b){
        sysFaced[sIndex]=b;
    }
    private static void setSysPoints(){
        for(int i=0;i<now;i++){
            sPoints[i]+=sbWickets[i]*15 + systemScores[i]*1.1 - sbRuns[i]*0.2;
            if(!res)
                sPoints[i]+=20;
        }
    }
    private static void setPoints(){
        for(int i=0;i<now;i++){
            points[i]+=ballWickets[i]*15 + playerScores[i]*1.1 -bowlRuns[i]*0.2;
            if(res)
                points[i]+=20;
        }
    }
    protected static double getMax(double[] a,double[] b){
        double m=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>m)
                m=a[i];
            if(b[i]>m)
                m=b[i];
        }
        return m;
    }
    protected static String print(String a,int b,int c){
        return a + " ".repeat(Math.max(0, 20 - a.length() + 1)) + b + "(" + c + ")";
    }
    protected static String print(String a,int b,int c,int d,int e){
        StringBuilder s= new StringBuilder(a);
        int i=s.length()-1;
        s.append(" ".repeat(Math.max(0, 20 - i)));
        s.append(b).append(".").append(c);
        i=s.length();
        s.append(" ".repeat(Math.max(0, 28 - i)));
        s.append(d);
        i=s.length();
        s.append(" ".repeat(Math.max(0,36-i)));
        s.append(e);
        return s.toString();
    }
    private static void initArrays(){
        playerNames=new String[now];
        playerScores=new int[now];
        systemScores=new int[now];
        systemNames=new String[now];
        ballFaced=new int[now];
        sysFaced=new int[now];
        ballOvers=new int[now];
        ballWickets=new int[now];
        bowlBalls=new int[now];
        bowlRuns=new int[now];
        points=new double[now];
        sbOvers=new int[now];
        sbWickets=new int[now];
        sbBalls=new int[now];
        sbRuns=new int[now];
        sPoints=new double[now];
    }
    public static void play(){
        Scanner sc = new Scanner(System.in);
        getPreInfo(sc);
        initArrays();
        addName(sc);
        sysName();
        System.out.println("Toss");
        System.out.println("\t1.Head\t2.Tail");
        Random r = new Random();
        tossing(sc, r);
        inning1(sc, r);
        System.out.println("Target : "+target);
        inning2(sc, r);
        result();
    }
    private static void getPreInfo(Scanner sc){
        System.out.println("Enter the number of overs(minimum 1): ");
        overs=sc.nextInt();
        System.out.println("Enter the number of Players(minimum 2): ");
        now=sc.nextInt();
    }
    protected static void addName(Scanner sc){
        System.out.println("Enter the player names:");
        for(int i=0;i<now;i++){
            System.out.print(i+1+" :");
            playerNames[i]=sc.next();
            ballOvers[i]=0;
            ballWickets[i]=0;
            bowlBalls[i]=0;
            bowlRuns[i]=0;
            points[i]=0;
        }
    }
    protected static void sysName(){
        for(int i=0;i<now;i++){
            systemNames[i]="Player "+(i+1);
            sbBalls[i]=0;
            sbWickets[i]=0;
            sbOvers[i]=0;
            sbRuns[i]=0;
            sPoints[i]=0;
        }
    }
    private static void inning1(Scanner sc,Random r){
        switch (inning) {
            case 1:
                batting(sc, r);
                break;
            case 2:
                bowling(sc, r);
                break;
        }
        target = in1 + 1;
    }
    private static void inning2(Scanner sc,Random r){
        switch (inning) {
            case 2:
                batting(sc, r, target);
                break;
            case 1:
                bowling(sc, r, target);
                break;
        }
    }
    protected static void newPlayer(String name){
        flag=false;
        System.out.println("New Batsman "+name);
    }
    private static void batting(Scanner sc, Random r) {
        int cw = now, ball, bat,co=overs,blr=0;
        System.out.println("Inning 1: You are Batting");
        flag=true;
        int score=0,bal=0,bf=0;
        index=0;
        while (cw > 0&&co>0) {
            if(bal==0){
                blr=r.nextInt(now);
                System.out.println("Bowler : "+systemNames[blr]);
            }
            if(flag)
                newPlayer(playerNames[index]);
            ball = balSysProb[r.nextInt(balsize)];
            boolean f=true;
            while(f) {
                try {
                    String b=sc.next();
                    bat = Integer.parseInt(b);
                    if(bat<0||bat>6)
                        throw new IllegalAccessException();
                    f=false;
                    System.out.println(bat + "    " + ball);
                    eBall++;
                    if(eBall==6){
                        eOver++;
                        eBall=0;
                    }
                    bf++;
                    bal++;
                    if(ball!=bat)
                        sbRuns[blr] += bat;
                    sbBalls[blr]++;
                    if (bal == 6) {
                        co--;
                        bal = 0;
                        sbBalls[blr]=0;
                        sbOvers[blr]++;
                    }

                    if (ball == bat) {
                        sbWickets[blr]++;
                        System.out.println("Out\t remaining wickets :" + --cw);
                        flag = true;
                        addBall(bf);
                        addScore(score);
                        bf=0;
                        score = 0;
                    }else {
                        in1 += bat;
                        score += bat;
                    }
                        if(bal==0)
                            dispOver(0,1,in1,cw);
                        else
                            dispOver(0, 1);
                    if (co == 0) {
                        addBall(bf);
                        addScore(score);
                    }
                    System.out.println();
                }
                catch(IllegalAccessException e){
                    System.out.println("Enter a valid score\n");
                }
                catch(Exception e){
                    System.out.println("Skip it");
                    f=false;
                }
            }
        }
        finalWicket=(now-cw);
        if(co==0)
            System.out.println(overs+" overs ended");
        if(cw==0)
            System.out.println("All out");
        System.out.println("Your score " + in1+"-"+(now-cw));
    }

    private static void batting(Scanner sc, Random r, int tr) {
        int cw = now, ball, bat,co=overs,blr=0;
        System.out.println("Inning 2: You are Batting");
        flag =true;
        int score=0,bf=0,bal=0;
        index=0;
        while (cw > 0 && in2 < target&&co>0) {
            if(bal==0){
                blr=r.nextInt(now);
                System.out.println("Bowler : "+systemNames[blr]);
            }
            if(flag)
                newPlayer(playerNames[index]);
            ball = balSysProb[r.nextInt(balsize)];
            boolean f=true;
            while(f) {
                try {
                    String b=sc.next();
                    bat = Integer.parseInt(b);
                    if(bat>6||bat<0)
                        throw new IllegalAccessException();
                    f=false;
                    System.out.println(bat + "    " + ball);
                    eBall++;
                    if(eBall==6){
                        eOver++;
                        eBall=0;
                    }
                    bf++;
                    bal++;
                    sbBalls[blr]++;
                    if(ball!=bat)
                        sbRuns[blr]+=bat;
                    if (bal == 6) {
                        co--;
                        bal = 0;
                        sbBalls[blr]=0;
                        sbOvers[blr]++;
                    }
                    if (ball == bat) {
                        sbWickets[blr]++;
                        System.out.println("Out\t remaining wickets :" + --cw);
                        flag = true;
                        addBall(bf);
                        addScore(score);
                        bf=0;
                        score = 0;
                    }else {
                        in2 += bat;
                        score += bat;
                    }
                    if(bal==0)
                        dispOver(target-in2,1,in2,cw);
                    else
                    if(target>in2)
                        dispOver(target - in2, 1);
                    if (in2 >= target || co == 0) {
                        addBall(bf);
                        addScore(score);
                    }
                    System.out.println();
                }
                catch(IllegalAccessException e){
                    System.out.println("Enter a valid score\n");
                }
                catch(Exception e){
                    System.out.println("Skip it");
                    f=false;
                }
            }
        }
        finalWicket=(now-cw);
        if(co==0)
            System.out.println(overs+" overs ended");
        if(cw==0)
            System.out.println("All out");
        System.out.println("Your score " + in2+"-"+(now-cw));
    }
    private static void bowling(Scanner sc, Random r) {
        System.out.println("Inning 1: You are Bowling");
        int cw = now, ball, bat,co=overs,blr=0;
        flag=true;
        sIndex=0;
        int score=0,bf=0,bal=0;
        while (cw > 0&&co >0) {
            boolean f=true;
            if(bal==0){
                boolean fl=true;
                System.out.println("Select bowler");
                while(fl){
                    try{
                        blr=sc.nextInt();
                        if(blr<1||blr>now){
                            throw new IllegalAccessException();
                        }
                        fl=false;
                        blr--;
                    }
                    catch(IllegalAccessException | InputMismatchException e){
                        System.out.println("Select a valid bowler");
                    }
                    catch(Exception e){
                        System.out.println("Skip it");
                    }
                }
                System.out.println("Bowler : "+playerNames[blr]);
            }
            if(flag){
                newPlayer(systemNames[sIndex]);
            }
            while(f) {
                try {
                    String b=sc.next();
                    ball = Integer.parseInt(b);
                    if(ball>6||ball<1)
                        throw new IllegalAccessException();
                    f=false;
                    bat = batSysProb[r.nextInt(batsize)];
                    System.out.println(ball + "    " + bat);
                    sBall++;
                    if(bat != ball)
                        bowlRuns[blr]+=bat;
                    bowlBalls[blr]++;
                    if(sBall==6){
                        sOver++;
                        sBall=0;
                        bowlBalls[blr]=0;
                        ballOvers[blr]++;
                    }
                    bf++;
                    bal++;
                    if (bal == 6) {
                        co--;
                        bal = 0;
                    }

                    if (ball == bat) {
                        ballWickets[blr]++;
                        System.out.println("Out\t remaining wickets :" + --cw);
                        flag = true;
                        sysBall(bf);
                        sysScore(score);
                        score = 0;
                        bf=0;
                    }
                    else
                    {
                        in1 += bat;
                        score += bat;
                    }
                    if(bal==0)
                        dispOver(0,2,in1,cw);
                    else
                        dispOver(0, 2);
                    if (co == 0) {
                        sysBall(bf);
                        sysScore(score);
                    }
                    System.out.println();
                }
                catch(IllegalAccessException e){
                    System.out.println("Enter a valid Ball\n");
                }
                catch(Exception e){
                    System.out.println("Skip it");
                    f=false;
                }
            }
        }
        sysWicket=(now-cw);
        if(co==0)
            System.out.println(overs+" overs ended");
        if(cw==0)
            System.out.println("All out");
        System.out.println("System score " + in1+"-"+(now-cw));
    }

    private static void bowling(Scanner sc, Random r, int tr) {
        int cw = now, ball, bat,co=overs,blr=0;
        flag=true;
        int score=0,bf=0,bal=0;
        sIndex=0;
        System.out.println("Inning 2: You are Bowling");
        while ((cw > 0) && (in2 < target) && (co > 0)) {
            if(bal==0){
                System.out.println("Select bowler");
                boolean fl=true;
                while(fl){
                    try{
                        blr=sc.nextInt();
                        if(blr<1||blr>now){
                            throw new IllegalAccessException();
                        }
                        fl=false;
                        blr--;
                    }
                    catch(IllegalAccessException | InputMismatchException e){
                        System.out.println("Select a valid bowler");
                    }
                    catch(Exception e){
                        System.out.println("Skip it");
                    }
                }
                System.out.println("Bowler : "+playerNames[blr]);
            }
            if(flag) {
                newPlayer(systemNames[sIndex]);
            }
            boolean f=true;
            while(f) {
                try{
                    String b=sc.next();
                    ball = Integer.parseInt(b);
                    if(ball>6||ball<1)
                        throw new IllegalAccessException();
                    f=false;
                    bat = batSysProb[r.nextInt(batsize)];
                    System.out.println(ball + "    " + bat);
                    sBall++;
                    bowlBalls[blr]++;
                    if(bat!=ball)
                        bowlRuns[blr]+=bat;
                    if(sBall==6){
                        sOver++;
                        sBall=0;
                        bowlBalls[blr]=0;
                        ballOvers[blr]++;
                    }bf++;
                    bal++;
                    if (bal == 6) {
                        co--;
                        bal = 0;
                    }
                    if (ball == bat) {
                        ballWickets[blr]++;
                        System.out.println("Out\t remaining wickets :" + --cw+"   needed "+ (target-in2));
                        sysBall(bf);
                        sysScore(score);
                        flag = true;
                        score = 0;
                        bf=0;
                    }
                    else {
                        in2 += bat;
                        score += bat;
                    }
                    if(bal==0)
                        dispOver(target-in2,2,in2,cw);
                    else if(target>in2)
                        dispOver(target - in2, 2);
                    if (in2 >= target || co == 0) {
                        sysBall(bf);
                        sysScore(score);
                    }
                    System.out.println();
                }
                catch(IllegalAccessException e){
                    System.out.println("Enter a valid Ball\n");
                }
                catch(Exception e){
                    System.out.println("Skip it");
                    f=false;
                }
            }
        }
        if(co==0)
            System.out.println(overs+" overs ended");
        if(cw==0)
            System.out.println("All out");
        sysWicket=(now-cw);
        System.out.println("System score " + in2+"-"+(now-cw));
    }
    private static void result() {
        int score_1=0,score_2=0;
        String a,b;
        switch (inning) {
            case 1:
                if (in2 >= target)
                    res = false;
                else
                    res = true;
                break;
            case 2:
                if (in2 >= target)
                    res = true;
                else
                    res = false;
                break;
        }
        if(in2==in1)
            System.out.println("Match tied");
        else if (res)
            System.out.println("You have won the Match!!");
        else
            System.out.println("You have lose the Match!!");
        switch (inning) {
            case 1:
                System.out.println("Inning 1");
                System.out.println("Batting : You");
                for (int i = 0; i < index; i++) {
                    a = print(playerNames[i], playerScores[i], ballFaced[i]);
                    System.out.println(a);
                    score_2 += playerScores[i];
                }
                System.out.println("Total\t\t\t\t" + score_2 + "-" + finalWicket + "  Overs " + eOver + "." + eBall);
                System.out.println("Bowling : System");
                for (int i = 0; i < now; i++) {
                    if (sbOvers[i] != 0 || sbBalls[i] != 0) {
                        b = print(systemNames[i], sbOvers[i], sbBalls[i], sbRuns[i], sbWickets[i]);
                        System.out.println(b);
                    }
                }
                System.out.println("Inning 2");
                System.out.println("Batting : System");
                for (int i = 0; i < sIndex; i++) {
                    a = print(systemNames[i], systemScores[i], sysFaced[i]);
                    System.out.println(a);
                    score_1 += systemScores[i];
                }
                System.out.println("Total\t\t\t\t" + score_1 + "-" + sysWicket + "  Overs " + sOver + "." + sBall);
                System.out.println("Bowling : You");
                for (int i = 0; i < now; i++) {
                    if (ballOvers[i] != 0 || bowlBalls[i] != 0) {
                        b = print(playerNames[i], ballOvers[i], bowlBalls[i], bowlRuns[i], ballWickets[i]);
                        System.out.println(b);
                    }
                }
                break;
            case 2:
                System.out.println("Inning 1");
                System.out.println("Batting : System");
                for (int i = 0; i < sIndex; i++) {
                    a = print(systemNames[i], systemScores[i], sysFaced[i]);
                    System.out.println(a);
                    score_1 += systemScores[i];
                }
                System.out.println("Total\t\t\t\t" + score_1 + "-" + sysWicket + "  Overs " + sOver + "." + sBall);
                System.out.println("Bowling : You");
                for (int i = 0; i < now; i++) {
                    if (ballOvers[i] != 0 || bowlBalls[i] != 0) {
                        b = print(playerNames[i], ballOvers[i], bowlBalls[i], bowlRuns[i], ballWickets[i]);
                        System.out.println(b);
                    }
                }
                System.out.println("Inning 2");
                System.out.println("Batting : You");
                for (int i = 0; i < index; i++) {
                    a = print(playerNames[i], playerScores[i], ballFaced[i]);
                    System.out.println(a);
                    score_2 += playerScores[i];
                }
                System.out.println("Total\t\t\t\t" + score_2 + "-" + finalWicket + "  Overs " + eOver + "." + eBall);
                System.out.println("Bowling : System");
                for (int i = 0; i < now; i++) {
                    if (sbOvers[i] != 0 || sbBalls[i] != 0) {
                        b = print(systemNames[i], sbOvers[i], sbBalls[i], sbRuns[i], sbWickets[i]);
                        System.out.println(b);
                    }
                }
        }
        setPoints();
        setSysPoints();
        System.out.println("Man of the match : ");
        double MoM=getMax(points,sPoints);
        for(int i=0;i<now;i++){
            if(MoM==points[i])
                System.out.println(playerNames[i]+"\t"+MoM);
            if(MoM==sPoints[i])
                System.out.println(systemNames[i]+"\t"+MoM);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter game option : ");
        System.out.println("\t1.Hand Cricket\t2.Over Match");
        Scanner sc= new Scanner(System.in);
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                HandCricket.play();
                break;
            case 2:
                OverMatch.play();
                break;
        }
    }
}