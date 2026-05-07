class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for(int i = 0; i < strs.length; i++){
            if(visited[i]){
                continue;
            }
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            visited[i] = true;

            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            for(int j = i+1; j< strs.length; j++){
                if(visited[j]){
                    continue;
                }
                if(strs[j].length()!=arr.length){
                    continue;
                }

                char[] arr2 = strs[j].toCharArray();
                Arrays.sort(arr2);
                if(Arrays.equals(arr,arr2)){
                    temp.add(strs[j]);
                    visited[j] = true;
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
