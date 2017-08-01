import com.tw.post.Postnet;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class PostnetTest {
    @Test
    public void should_return_barcode_given_1(){
        //given
        int digit = 1;
        //when
        Postnet postnet = new Postnet();
        String barcode = postnet.convertDigit(digit);
        //then
        assertThat(barcode).isEqualTo(":::||");
    }

    @Test
    public void should_return_barcode_given_2(){
        //given
        int digit = 2;
        //when
        Postnet postnet = new Postnet();
        String barcode = postnet.convertDigit(digit);
        //then
        assertThat(barcode).isEqualTo("::|:|");
    }

    @Test
    public void should_return_barcode_given_3(){
        //given
        int digit = 3;
        //when
        Postnet postnet = new Postnet();
        String barcode = postnet.convertDigit(digit);
        //then
        assertThat(barcode).isEqualTo("::||:");
    }

    @Test
    public void should_return_barcode_given_4(){
        //given
        int digit = 4;
        //when
        Postnet postnet = new Postnet();
        String barcode = postnet.convertDigit(digit);
        //then
        assertThat(barcode).isEqualTo(":|::|");
    }

    @Test
    public void should_return_barcode_given_5(){
        //given
        int digit = 5;
        //when
        Postnet postnet = new Postnet();
        String barcode = postnet.convertDigit(digit);
        //then
        assertThat(barcode).isEqualTo(":|:|:");
    }

    @Test
    public void should_return_barcode_given_6(){
        //given
        int digit = 6;
        //when
        Postnet postnet = new Postnet();
        String barcode = postnet.convertDigit(digit);
        //then
        assertThat(barcode).isEqualTo(":||::");
    }

    @Test
    public void should_return_barcode_given_7(){
        //given
        int digit = 7;
        //when
        Postnet postnet = new Postnet();
        String barcode = postnet.convertDigit(digit);
        //then
        assertThat(barcode).isEqualTo("|:::|");
    }

    @Test
    public void should_return_barcode_given_8(){
        //given
        int digit = 8;
        //when
        Postnet postnet = new Postnet();
        String barcode = postnet.convertDigit(digit);
        //then
        assertThat(barcode).isEqualTo("|::|:");
    }

    @Test
    public void should_return_barcode_given_9(){
        //given
        int digit = 9;
        //when
        Postnet postnet = new Postnet();
        String barcode = postnet.convertDigit(digit);
        //then
        assertThat(barcode).isEqualTo("|:|::");
    }

    @Test
    public void should_return_barcode_given_0(){
        //given
        int digit = 0;
        //when
        Postnet postnet = new Postnet();
        String barcode = postnet.convertDigit(digit);
        //then
        assertThat(barcode).isEqualTo("||:::");
    }

}
