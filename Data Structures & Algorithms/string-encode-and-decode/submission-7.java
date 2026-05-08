class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();
        for(String s: strs){
            ans.append("☠").append("☢").append(s);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '☢'){
                String s  = "";
                int j = i+1;
                while(j < str.length() && !(str.charAt(j) == '☠')){
                    char ch = str.charAt(j);
                    s+=ch;
                    j++;
                }
                if(s.isEmpty()){
                    ans.add("");
                }else{
                    char ch1 = s.charAt(s.length()-1);

                    if(ch1 == '☠'){
                        ans.add(s.substring(0, s.length()-1));
                    }else{
                        ans.add(s);
                    }
                }
            }
           if(str.charAt(i) == '☠'){
               continue;
           }
        }
        return ans;
    }
}
