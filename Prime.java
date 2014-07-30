public class Prime{
  public static int nextPrime(int p){
    int c;
    int i;
    if (p==2) return 3;
    else {
      for(i=p+2;i<p+1000;i+=2) {
        c=0;
        if(i%2==0) c++;
        for (int j=3;j<(double)(Math.pow(i,0.5)+1);j+=2){
          if (i%j==0) {
            c++;
            break;
          }
        }
        if (c==0) break;
      }
      return i;
    }
  }


  public static int backPrime(int p){
    int c;
    int i;
    if (p==3) return 2;
    else{
    for(i =p-2;i>p/2-1;i-=2){
      c=0;
      if(i%2==0)c++;
      for(int j=3;j<(double)(Math.pow(i,0.5)+1);j+=2){
        if (i%j==0){
          c++;
          continue;
        }
      }
      if (c==0) break;
    }
    return i;
    }

  }

  public static int prime(int p){
    int i;
    int n=2;
    for(i=0;i<p;i++){
      n=nextPrime(n);
    }
    return n;
  }


  public static int arcPrime(int p){
    int i;
    int n=0;
    int t;

    if      (p>=64553) t=10;
    else if (p>=23531) t=9;
    else if (p>=8419)  t=8;
    else if (p>=3061)  t=7;
    else if (p>=1009)  t=6;
    else               t=5;
    for (i=p/(t+1);i<p/(t-4);i++){
      if(prime(i)==p) {
        n=i;
        break;
      }
    }
    return n;
  }



}
