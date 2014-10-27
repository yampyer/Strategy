package strategy;

public class BubbleSort implements Strategy {

    @Override
    public String execute(int n, int[] arr) {
    for (int c = 0; c < (n-1); ++c) {
      for (int d = 0; d < n-c-1; ++d) {
        if (arr[d] > arr[d+1]) {
          int swap = arr[d];
          arr[d] = arr[d+1];
          arr[d+1] = swap;
        }
      }
    }
    String res = "";
    for (int c : arr) res += c + " ";
    return res; 
    }
  }
