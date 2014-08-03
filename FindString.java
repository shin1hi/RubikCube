public class FindString{

  //100文字までの文字列を検索
  public static void findString(String str,String findStr){
    try {
    char[] c= new char[str.length()];
    for(int i=0;i<str.length();i++){
      c[i] =str.charAt(i);

      //findStringを検証中
      if (c[i]==findStr.charAt(0)){
        for (int j=1;j<findStr.length()-1;j++){
          while(i+j<str.length())
          if (c[i+j] != findStr.charAt(j)) break;
        }
        if (c[i+(findStr.length())-1]==findStr.charAt(findStr.length()-1)){
        System.out.println("\"" + findStr +"\"がみつかりました" );
        }
      }




    }
  }catch (Exception e){}


  }
}
