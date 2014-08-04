class AnswerExplorer extends P{

	static int co;
	static int edgeOrientation;
	static int es;
  String path;

  AnswerExplorer(){}
	AnswerExplorer(int co,int eo, int es){
		this.co=co;
		this.edgeOrientation=eo;
		this.es=es;

	}


  void explorer(){}
  void rotate(){}
  void makePath(){}
  

}


class CO extends AnswerExplorer{
  void explorer(){

  }
  void rotate(){

  }

}

class EO extends AnswerExplorer{
	int[] eo;


  //constructor
	EO (int edgeOrientation){
		//1 2 4 8 16 32 64 128 256 512 1024 2048
		eo  = new int[12];
		for (int i=0;i<12;i++){
			eo[i]=(edgeOrientation >>> i)%2;  //i =0...11
		}
		// 0 01                        
		// 1 02
		// 2 04
		// 3 05
		// 4 12
		// 5 13
		// 6 15
		// 7 23
		// 8 24
		// 9 34
		//10 35
		//11 45
        //    2 eo ->1,4,7,8    && 1>4 4>7 7>8 8>1

        //	  5 eo ->3,6,10,11  && 6>3 3>11 11>10 10>6
		
  }

  void explorer(){
    /*String[] str = new String[100000000000000L];



    /*MCT(root) {
      while (loop until 終了条件) {
        leaf <- select_downwards(root)
        leaf.n <- leaf.n + 1
        if (expand_cond(leaf)) {
          leaf <- expand(leaf).first_child
        }
        board = playout(leaf.board)
        update_upwards(leaf, getvalue(board))
      }
      return select_best_child(root)
    }*/






/*
    	for (int i = 0; i<10 ;i ++)out:{
        for (int j = 0 ; j <Math.pow(6,i+1);j++){
          for (int k = 0 ; k<i;k++){
            str[j] += "" +j/(Math.pow(6,i-k));
            if (k=i-1) str[j] +=j%6;
          }
        }



          


          switch (j){
            case 0: 
            int p =p*p(j)
          } 
          int p = p*p(j) 
          eeo[p][] = eeo[][]
          rotate();
          path += ""+ j;

          if (eo[0]==0&&
            eo[1]==0&&
            eo[2]==0&&
            eo[3]==0&&
            eo[4]==0&&
            eo[5]==0&&
            eo[6]==0&&
            eo[7]==0&&
            eo[8]==0&&
            eo[9]==0&&
            eo[10]==0&&
            eo[11]==0

                        ) {break out;}
        }
        
    	}*/
  }
  void makePath(){
    String[] str = new String[1000000];
    int j=0;
    for (int i = 0; i<4 ;i ++)out:{
      
      int l=j;
      for (j=0 ; j<(Math.pow(6,i+1));j++){
        for (int k = 0 ; k<i;k++){
          if (k==i-1) str[j] += "" + (int)(j%6);
          else      str[j+l] += "" +(int)(j/(Math.pow(6,i-k)));
          
          
          

        }
      }
    }
    for (String s : str){
      System.out.println(s);
      if (s==null) break;


    }
    


  }

  
  void rotate (int n){
  	switch (n){
  		case 0: 
  		int box = eo[0];
  		eo[0]	= eo[3];
  		eo[3]	= eo[2];
  		eo[2]	= eo[1];
  		eo[1]	= box;
  		break;
  		case 1: 
  		box 	= eo[4];
  		eo[4]	= eo[5];
  		eo[5]	= eo[6];
  		eo[6]	= eo[0];
  		eo[0]	= box;
  		break;
  		case 2: 
  		box 	= eo[8];
  		eo[8]	= (eo[7]+1)%2;
  		eo[7]	= (eo[4]+1)%2;
  		eo[4]	= (eo[1]+1)%2;
  		eo[1]	= (box+1)%2;
  		break;
  		case 3: 
  		box		= eo[9];
  		eo[9]	= eo[10];
  		eo[10]	= eo[5];
  		eo[5]	= eo[7];
  		eo[7]	= box;
  		break;
  		case 4: 
  		box 	= eo[11];
  		eo[11]	= eo[9];
  		eo[9]	= eo[8];
  		eo[8]	= eo[2];
  		eo[2]	= box;
  		break;
  		case 5: 
  		box 	= eo[11];
  		eo[11]	= (eo[3]+1)%2;
  		eo[3]	= (eo[6]+1)%2;
  		eo[6]	= (eo[10]+1)%2;
  		eo[10]	= (box+1)%2;
  		break;	
  	}
    
  }
  public static void main(String[] args){
    AnswerExplorer a = new EO(1000);
    a.explorer();
    a.makePath();

  }





}

class ES extends AnswerExplorer{
    void explorer(){

    }
    void rotate(){

    }
}
