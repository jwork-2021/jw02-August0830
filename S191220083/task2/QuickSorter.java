package task2;

public class QuickSorter implements Sorter{
    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    private int partition(int left,int right){
        int i=left,j=right;
        int key = right;
        while(i<j){
            while( i<j && a[i]<=a[key]) ++i;
            while(i<j && a[key]<=a[j]) -- j;
            swap(i,j);
        }
        swap(i,key);
        return i;
    }
    private void quickSort(int left,int right){
        if(right<=left)
            return;
        int i = partition(left, right);
        quickSort(left, i-1);
        quickSort(i+1, right);
    }
    @Override
    public void sort() {
        quickSort(0, a.length-1);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}