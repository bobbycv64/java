public class Arrays {
  
  public static void main(String[] args) {

    int[]   arrayOfIntegers = new int[10];
    float[] arrayOfFloats = new float[10];

    for (int i = 0; i < 10; i++) {
      arrayOfIntegers[i] = i;
      arrayOfFloats[i] = i * 13.64f;
    }

    for (int i = 0; i < 10; i++) {
      System.out.println(arrayOfIntegers[i] + " " + 
        arrayOfFloats[i]);
    }
  }
}