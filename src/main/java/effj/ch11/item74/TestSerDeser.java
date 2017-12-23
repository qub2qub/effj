package effj.ch11.item74;

public class TestSerDeser {
    /*SonarMeasuresWrapper body = responseEntity.getBody();
    FileOutputStream file = null;
    try
    {
      file = new FileOutputStream("D:\\SonarMeasures.ser", true);
      //    ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ObjectOutputStream out = new ObjectOutputStream(file);
      out.writeObject(body);
      //    System.out.println(Arrays.toString(bos.toByteArray()));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }*/

    /*
    public SonarMeasuresWrapper getMockedMetrics()
  {
    SonarMeasuresWrapper metrics = null;
    try
    {
      FileInputStream fis = new FileInputStream("D:\\SonarMeasures.ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
      metrics = (SonarMeasuresWrapper) ois.readObject();
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return metrics;
  }
     */
}
