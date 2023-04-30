public static int gridTravel(int m, int n) {
        int[][] a = new int[m][n];
        a[0][0] = 1;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(j+1 < n) {
                    a[i][j+1] += a[i][j];
                }
                if(i+1<n) {
                    a[i+1][j] += a[i][j];
                }
            }
        }

        return a[m-1][n-1];
    }

    public static boolean cansum(int m, int[] a) {
        boolean[] a1 = new boolean[m+1];
        int n = a.length;
        a1[0] = true;
        for(int i=0;i<m+1;i++) {
            if(!a1[i]) {
                continue;
            }
            for (int k : a) {
                if(i+k < m+1) a1[i + k] = true;
            }
        }

        return a1[m];
    }

    public static final ArrayList<Integer> howSum(int s, int[] a) {
        int n = a.length;
        ArrayList<Integer>[] al = new ArrayList[s+1];
        al[0] = new ArrayList<>();
        for(int i=0;i<s+1;i++) {
            if(al[i] == null) continue;

            for (int k : a) {
                if(i+k > s || al[i+k] != null) continue;
                ArrayList<Integer> al1 = new ArrayList<>(al[i]);
                al1.add(k);
                al[i + k] = al1;
            }
        }

        return al[s];
    }

    public static final ArrayList<Integer> bestSum(int s, int[] a) {
        int n = a.length;
        ArrayList<Integer>[] al = new ArrayList[s+1];
        al[0] = new ArrayList<>();

        for(int i=0;i<s+1;i++) {
            if(al[i] == null) continue;
            for(int j=0;j<n;j++) {
                if(i+a[j] > s) continue;
                ArrayList<Integer> al1 = new ArrayList<>(al[i]);
                al1.add(a[j]);
                if(al[i+a[j]] == null) {
                    al[i+a[j]] = al1;
                }
                else if(al[i+a[j]].size() > al1.size()){
                    al[i+a[j]] = al1;
                }
            }
        }

        return al[s];
    }

static int countWayStringDp(String target, String[] a) {
        int m = target.length();
        int n = a.length;
        int[] c = new int[m+1];
        c[0] = 1;
        for(int i=0;i<m+1;i++) {
            if(c[i] == 0) continue;
            String subStr = target.substring(i);
            for (String s : a) {
                if (subStr.startsWith(s)) {
                    int ni = i + s.length();
                    if (ni > m) continue;
                    c[ni] += c[i];
                }
            }
        }

        return c[target.length()];
    }
