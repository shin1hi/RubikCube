class Analyse2 {
  public static void distance(int[][] c) {
    int i,j,k,l,m,n;
    String[][] d= new String[14][1002];

    for (i=0;i<6;i++){
        for (j=0;j<6;j++){
            m = 0;
            if (((6+j*Math.pow(-1,j))%6)==((6+2*Math.pow(-1,j))%6)||((6+j*Math.pow(-1,j))%6)==((6+5*Math.pow(-1,j))%6)) m=1;
            else if (j==0||j==3)continue;
            c[p(i)][p(i)*p(i+j)*p(i+j+1+m)]=p(i);
            n=j+m+1

            for (k=0;k<6;k++):out {
              if (c[p(i)][p(i)*p(i+j)]!=p(k)) continue;
              for (l=0;l<6;l++){
                if (c[p(i+j)][p(i)*p(i+j)]=p(l)) continue;
                //now c[i][]=p(k) , c[i+j][]=p(l)
                break out;
              }
            }
            if (((6+k-i*Math.pow(-1,i))%6)==0) {
              switch ((6+l-j*Math.pow(-1,j))%6) {
                case 0:d[i][j]="r"+i+"0";break;
                case 1:
                case 2:d[i][j]="r"+i+"1";break;
                case 3:d[i][j]="r"+i+"2";break;
                case 4:
                case 5:d[i][j]="r"+i+"3";break;
              }

            }else if (((6+k-i*Math.pow(-1,i))%6)==3){
              switch ((6+l-j*Math.pow(-1,j))%6) {
                case 0:d[i][j]="r"+j+"2,r"+i+"0";break;
                case 1:
                case 2:d[i][j]="r"+j+"2,r"+i+"1";break;
                case 3:d[i][j]="r"+j+"2,r"+i+"2";break;
                case 4:
                case 5:d[i][j]="r"+j+"2,r"+i+"3";break;
              }
            }else if ((6+k-j)%6==0){//k=j
              if (l==i) d[i][j]=reverse(i,j);//l=i
              else if (((l-i+9)%6)==0) d[i][j]="r"+j+"2"+reverse(i,j) ;//l=i+3
              else if ((6+k-(j+1+m)*Math.pow(-1,j))%6==0); d[i][j]="r"+j+"1"+reverse(i,j); //k=(j+1+m)*
              else if ((6+k-(j+4+m)*Math.pow(-1,j))%6==0); d[i][j]="r"+j+"3"+reverse(i,j); //k=(j+4+m)*

            }else if ((6+k-(j+1+m)*Math.pow(-1,j))%6==0){//k=j+1+m
                if (l==i) d[i][j]=reverse(i,j+1+m)+"r"+i+"3";//l=i
                else if (((l-i+9)%6)==0)                    d[i][j]="r"+(j+1+m) +"2,r"+(j)+""+(2+Math.pow(-1,i));//l=j+3
                else if ((6+k-(j+1+m)*Math.pow(-1,j))%6==0) d[i][j]="r"+(j+1+m) +""+ (2+Math.pow(-1,i))+",r"+(j)+""+(2+Math.pow(-1,i)); //l=i+3
                else if ((6+k-j)%6==0) d[i][j]="r"+j+""+(2+Math.pow(-1,i));//l=j

            }else if ((6+k-(j+4+m)*Math.pow(-1,j))%6==0){//k=j+4+m
              if (l==i) d[i][j]=reverse(i,j+4+m)+"r"+i+"1";//l=i
              else if (((l-i+9)%6)==0) d[i][j]="r"+j+"2,reverse" ;//l=i+3
              else if ((6+k-(j+1+m)*Math.pow(-1,j))%6==0); d[i][j]="r"+j+"1,reverse" //k=(j+1+m)*
              else if ((6+k-(j+4+m)*Math.pow(-1,j))%6==0); d[i][j]="r"+j+"3,reverse" //k=(j+4+m)*

            }else if ((6+k-j)%6==0){//k=j
              if (l==i) d[i][j]="reverse";//l=i
              else if (((l-i+9)%6)==0) d[i][j]="r"+j+"2,reverse" ;//l=i+3
              else if ((6+k-(j+1+m)*Math.pow(-1,j))%6==0); d[i][j]="r"+j+"1,reverse" //k=(j+1+m)*
              else if ((6+k-(j+4+m)*Math.pow(-1,j))%6==0); d[i][j]="r"+j+"3,reverse" //k=(j+4+m)*

            }


        }
      }
}
