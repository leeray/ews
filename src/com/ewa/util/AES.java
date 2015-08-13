package com.ewa.util;  
  
import java.io.UnsupportedEncodingException;  
import java.security.InvalidKeyException;  
import java.security.NoSuchAlgorithmException;  
import java.security.SecureRandom;  
  
import javax.crypto.BadPaddingException;  
import javax.crypto.Cipher;  
import javax.crypto.IllegalBlockSizeException;  
import javax.crypto.KeyGenerator;  
import javax.crypto.NoSuchPaddingException;  
import javax.crypto.SecretKey;  
import javax.crypto.spec.SecretKeySpec;  

import org.apache.commons.codec.binary.Base64;


//import org.apache.axis.encoding.Base64;  
  
//public class AES {  
//    /** 
//      * 加密 
//     *  
//      * @param content 需要加密的内容 
//     * @param password  加密密码 
//     * @return 
//      */   
//     public static byte[] encrypt(String content, String password) {   
//             try {              
//                     KeyGenerator kgen = KeyGenerator.getInstance("AES");   
//                     kgen.init(128, new SecureRandom(password.getBytes()));   
//                     SecretKey secretKey = kgen.generateKey();   
//                     byte[] enCodeFormat = secretKey.getEncoded();   
//                     SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");   
//                     Cipher cipher = Cipher.getInstance("AES");// 创建密码器   
//                     byte[] byteContent = content.getBytes("utf-8");   
//                     cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化   
//                     byte[] result = cipher.doFinal(byteContent);   
//                     return result; // 加密   
//             } catch (NoSuchAlgorithmException e) {   
//                     e.printStackTrace();   
//             } catch (NoSuchPaddingException e) {   
//                     e.printStackTrace();   
//             } catch (InvalidKeyException e) {   
//                     e.printStackTrace();   
//             } catch (UnsupportedEncodingException e) {   
//                     e.printStackTrace();   
//             } catch (IllegalBlockSizeException e) {   
//                     e.printStackTrace();   
//             } catch (BadPaddingException e) {   
//                     e.printStackTrace();   
//             }   
//             return null;   
//     }   
//       
//     /**解密 
//      * @param content  待解密内容 
//      * @param password 解密密钥 
//      * @return 
//       */   
//      public static byte[] decrypt(byte[] content, String password) {   
//              try {   
//                       KeyGenerator kgen = KeyGenerator.getInstance("AES");   
//                       kgen.init(128, new SecureRandom(password.getBytes()));   
//                       SecretKey secretKey = kgen.generateKey();   
//                       byte[] enCodeFormat = secretKey.getEncoded();   
//                       SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");               
//                       Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");// 创建密码器   
//                      cipher.init(Cipher.DECRYPT_MODE, key);// 初始化   
//                      byte[] result = cipher.doFinal(content);   
//                      return result; // 加密   
//              } catch (NoSuchAlgorithmException e) {   
//                      e.printStackTrace();   
//              } catch (NoSuchPaddingException e) {   
//                      e.printStackTrace();   
//              } catch (InvalidKeyException e) {   
//                      e.printStackTrace();   
//              } catch (IllegalBlockSizeException e) {   
//                      e.printStackTrace();   
//              } catch (BadPaddingException e) {   
//                      e.printStackTrace();   
//              }   
//              return null;   
//      }  
//        
//        
//      /**将二进制转换成16进制 
//       * @param buf 
//        * @return 
//        */   
//       public static String parseByte2HexStr(byte buf[]) {   
//               StringBuffer sb = new StringBuffer();   
//               for (int i = 0; i < buf.length; i++) {   
//                       String hex = Integer.toHexString(buf[i] & 0xFF);   
//                       if (hex.length() == 1) {   
//                               hex = '0' + hex;   
//                       }   
//                       sb.append(hex.toUpperCase());   
//               }   
//               return sb.toString();   
//       }   
//         
//       /**将16进制转换为二进制 
//        * @param hexStr 
//         * @return 
//         */   
//        public static byte[] parseHexStr2Byte(String hexStr) {   
//                if (hexStr.length() < 1)   
//                        return null;   
//                byte[] result = new byte[hexStr.length()/2];   
//                for (int i = 0;i< hexStr.length()/2; i++) {   
//                        int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);   
//                        int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);   
//                        result[i] = (byte) (high * 16 + low);   
//                }   
//                return result;   
//        }   
//          
//        /** 
//           * 加密 
//          * 
//           * @param content 需要加密的内容 
//          * @param password  加密密码 
//          * @return 
//           */   
//          public static byte[] encrypt2(String content, String password) {   
//                  try {   
//                          SecretKeySpec key = new SecretKeySpec(password.getBytes(), "AES");   
//                          Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");   
//                          byte[] byteContent = content.getBytes("utf-8");   
//                          cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化   
//                          byte[] result = cipher.doFinal(byteContent);   
//                          return result; // 加密   
//                  } catch (NoSuchAlgorithmException e) {   
//                          e.printStackTrace();   
//                  } catch (NoSuchPaddingException e) {   
//                          e.printStackTrace();   
//                  } catch (InvalidKeyException e) {   
//                          e.printStackTrace();   
//                  } catch (UnsupportedEncodingException e) {   
//                          e.printStackTrace();   
//                  } catch (IllegalBlockSizeException e) {   
//                          e.printStackTrace();   
//                  } catch (BadPaddingException e) {   
//                          e.printStackTrace();   
//                  }   
//                  return null;   
//          }   
//        
//      public static void main(String[] args) {  
//          String content = "test";   
//          String password = "12345678";   
//          //加密   
//         System.out.println("加密前：" + content);   
//         byte[] encryptResult = encrypt(content, password);  
//         String tt4 = Base64.encodeBase64String(encryptResult);
//        		 
//         System.out.println(new String(tt4));  
//           
//          //解密   
//         byte[] decryptResult = decrypt(encryptResult,password);   
//         System.out.println("解密后：" + new String(decryptResult));   
//    }  
      
      import java.util.Arrays;  
      
      import javax.crypto.Cipher;  
      import javax.crypto.KeyGenerator;  
      import javax.crypto.SecretKey;  
      import javax.crypto.spec.IvParameterSpec;  
        
      /** 
       * AES 算法 对称加密，密码学中的高级加密标准 2005年成为有效标准  
       * @author stone 
       * @date 2014-03-10 06:49:19 
       */  
      public class AES {  
          static Cipher cipher;  
          static final String KEY_ALGORITHM = "AES";  
          static final String CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS5Padding";  
          /* 
           *  
           */  
          static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";  
          /*  
           * AES/CBC/NoPadding 要求 
           * 密钥必须是16位的；Initialization vector (IV) 必须是16位 
           * 待加密内容的长度必须是16的倍数，如果不是16的倍数，就会出如下异常： 
           * javax.crypto.IllegalBlockSizeException: Input length not multiple of 16 bytes 
           *  
           *  由于固定了位数，所以对于被加密数据有中文的, 加、解密不完整 
           *   
           *  可 以看到，在原始数据长度为16的整数n倍时，假如原始数据长度等于16*n，则使用NoPadding时加密后数据长度等于16*n， 
           *  其它情况下加密数据长 度等于16*(n+1)。在不足16的整数倍的情况下，假如原始数据长度等于16*n+m[其中m小于16]， 
           *  除了NoPadding填充之外的任何方 式，加密数据长度都等于16*(n+1). 
           */  
          static final String CIPHER_ALGORITHM_CBC_NoPadding = "AES/CBC/NoPadding";   
            
          static SecretKey secretKey;  
                
          public static void main(String[] args) throws Exception {  
              method1("a*jal)k32J8czx囙国为国宽");  
              method2("a*jal)k32J8czx囙国为国宽");  
              method3("a*jal)k32J8czx囙国为国宽");  
                
              method4("123456781234囙为国宽");// length = 16  
              method4("12345678abcdefgh");// length = 16  
                
          }  
            
          /** 
           * 使用AES 算法 加密，默认模式  AES/ECB 
           */  
          static void method1(String str) throws Exception {  
              cipher = Cipher.getInstance(KEY_ALGORITHM);  
              //KeyGenerator 生成aes算法密钥  
              secretKey = KeyGenerator.getInstance(KEY_ALGORITHM).generateKey();  
              System.out.println("密钥的长度为：" + secretKey.getEncoded().length);  
                
              cipher.init(Cipher.ENCRYPT_MODE, secretKey);//使用加密模式初始化 密钥  
              byte[] encrypt = cipher.doFinal(str.getBytes()); //按单部分操作加密或解密数据，或者结束一个多部分操作。  
                
              System.out.println("method1-加密：" + new String(encrypt));  
              cipher.init(Cipher.DECRYPT_MODE, secretKey);//使用解密模式初始化 密钥  
              byte[] decrypt = cipher.doFinal(encrypt);  
              System.out.println("method1-解密后：" + new String(decrypt));  
                
          }  
            
          /** 
           * 使用AES 算法 加密，默认模式 AES/ECB/PKCS5Padding 
           */  
          static void method2(String str) throws Exception {  
              cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);  
              //KeyGenerator 生成aes算法密钥  
              secretKey = KeyGenerator.getInstance(KEY_ALGORITHM).generateKey();  
              System.out.println("密钥的长度为：" + secretKey.getEncoded().length);  
                
              cipher.init(Cipher.ENCRYPT_MODE, secretKey);//使用加密模式初始化 密钥  
              byte[] encrypt = cipher.doFinal(str.getBytes()); //按单部分操作加密或解密数据，或者结束一个多部分操作。  
                
              System.out.println("method2-加密：" + new String(encrypt));  
              cipher.init(Cipher.DECRYPT_MODE, secretKey);//使用解密模式初始化 密钥  
              byte[] decrypt = cipher.doFinal(encrypt);  
              System.out.println("method2-解密后：" + new String(decrypt));  
                
          }  
            
          static byte[] getIV() {  
              String iv = "1234567812345678"; //IV length: must be 16 bytes long  
              return iv.getBytes();  
          }  
            
          /** 
           * 使用AES 算法 加密，默认模式 AES/CBC/PKCS5Padding 
           */  
          static void method3(String str) throws Exception {  
              cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);  
              //KeyGenerator 生成aes算法密钥  
              secretKey = KeyGenerator.getInstance(KEY_ALGORITHM).generateKey();  
              System.out.println("密钥的长度为：" + secretKey.getEncoded().length);  
                
              cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(getIV()));//使用加密模式初始化 密钥  
              byte[] encrypt = cipher.doFinal(str.getBytes()); //按单部分操作加密或解密数据，或者结束一个多部分操作。  
                
              System.out.println("method3-加密：" + new String(encrypt));  
              cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(getIV()));//使用解密模式初始化 密钥  
              byte[] decrypt = cipher.doFinal(encrypt);  
              System.out.println("method3-解密后：" + new String(decrypt));  
                
          }  
            
          /** 
           * 使用AES 算法 加密，默认模式 AES/CBC/NoPadding  参见上面对于这种mode的数据限制 
           */  
          static void method4(String str) throws Exception {  
              cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC_NoPadding);  
              //KeyGenerator 生成aes算法密钥  
              secretKey = KeyGenerator.getInstance(KEY_ALGORITHM).generateKey();  
              System.out.println("密钥的长度为：" + secretKey.getEncoded().length);  
                
              cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(getIV()));//使用加密模式初始化 密钥  
              byte[] encrypt = cipher.doFinal(str.getBytes(), 0, str.length()); //按单部分操作加密或解密数据，或者结束一个多部分操作。  
                
              System.out.println("method4-加密：" + new String(encrypt));  
              cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(getIV()));//使用解密模式初始化 密钥  
              byte[] decrypt = cipher.doFinal(encrypt);  
                
              System.out.println("method4-解密后：" + new String(decrypt));  
                
          } 
} 