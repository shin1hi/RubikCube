class AnswerExplorer{
	int co;
	int eo;
	int es;
	AnswerExplorer(int co,int eo, int es){
		this.co=co;
		this.eo=eo;
		this.es=es;

	}


  abstract void explorer();
  abstract int rotate(int oo);
  

}


class CO extends AnswerExplorer{


}

class EO extends AnswerExplorer{
	int[] eo;

	EO (int eo){
		//1 2 4 8 16 32 64 128 256 512 1024 2048
		eo  = new int[12];
		for (int i;i<12;i++){
			eo[i]=(eo >>> i)%2  //i =0...11
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
    	for (int i = 0; i<50 ;i ++){
    		rotate
    	}





    int[] rotate (int n){
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


}

class ES extends AnswerExplorer{

}
