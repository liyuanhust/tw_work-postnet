import com.google.common.collect.Lists;
import com.tw.post.CollectionUtil;
import com.tw.post.Postnet;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

public class PostnetTest {

    @Test
    public void should_return_false_given_notdigit(){
        //given
        String post = "abc123";
        //when
        Postnet postnet = new Postnet();
        String result = postnet.convertPostToZipCode(post);
        //then
        assertThat(result).isEqualTo("");
    }

    @Test
    public void should_return_false_given_wrong_digit(){
        //given
        String post = "123456";
        //when
        Postnet postnet = new Postnet();
        String result = postnet.convertPostToZipCode(post);
        //then
        assertThat(result).isEqualTo("");
    }

    @Test
    public void should_return_formatNumber_given_unformatNumber(){
        //given
        String postNumber = "1234-55555";
        //when
        Postnet postnet = new Postnet();
        List<Integer> result = postnet.formatPost(postNumber);
        //then
        StringBuilder resultStr = new StringBuilder();
        for (int i:result) {
            resultStr.append(i);
        }
        assert CollectionUtil.converIntListToString(result).equals("123455555");
    }


    @Test
    public void should_return_verifyCode_given_digitList(){
        List<Integer> digitList = Lists.newArrayList(9,5,7,1,3);
        Postnet postnet = new Postnet();
        int vieryCode = postnet.caclutateVerifyCode(digitList);
        assertThat(vieryCode).isEqualTo(5);
    }


    @Test
    public void should_return_barcode_given_digitList(){
        List<Integer> digitList = Lists.newArrayList(1,2,3,4,5,6,7,8,9,0);
        Postnet postnet = new Postnet();
        String barcodes = postnet.convertDigitListToBarcodes(digitList);
        assertThat(barcodes).isEqualTo(":::||::|:|::||::|::|:|:|::||::|:::||::|:|:|::||:::");
    }

    @Test
    public void should_return_StartAndStrop_barcode_given_inputPostNumber(){
        String postNumber = "95713";
        Postnet postnet = new Postnet();
        String zipCode = postnet.convertPostToZipCode(postNumber);
        assert zipCode.startsWith("|");
        assert zipCode.endsWith("|");
    }

    @Test
    public void should_return_zipCode_given_post_number(){
        String postNumber = "95713";
        Postnet postnet = new Postnet();
        String zipCode = postnet.convertPostToZipCode(postNumber);
        assert zipCode.equals("||:|:::|:|:|:::|:::||::||::|:|:|");
    }


    @Test
    public void should_return_invalidate_given_wrong_zipCode(){
        String zipCode = "|||";
        Postnet postnet = new Postnet();
        String post = postnet.convertZipCodeToPost(zipCode);
        assert post.equals(Postnet.INVALIDATE_POST);
    }

    @Test
    public void should_return_digit_list_given_zipCode(){
        String zipCode = "||:|:::|:|:|:::|:::||::||::|:|:|";
        Postnet postnet = new Postnet();
        List<Integer> digitList = postnet.covertZipcodeToDigitList(zipCode);
        assert CollectionUtil.converIntListToString(digitList).equals("957135");
    }

    @Test
    public void should_return_false_when_given_wrong_verify_code() {
        List<Integer> digitList = Lists.newArrayList(9,5,7,1,3,6);
        Postnet postnet = new Postnet();
        boolean verifyResult = postnet.verifyPostDigits(digitList);
        assert !verifyResult;
    }

    @Test
    public void should_return_postcode_when_given_zipcode(){
        String zipCode = "||:|:::|:|:|:::|:::||::||::|:|:|";
        Postnet postnet = new Postnet();
        String postCode = postnet.convertZipCodeToPost(zipCode);
        assert  postCode.equals("95713");
    }
}
