package com.Dibike.common;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”
 */

public class AlipayConfig {

	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088521157835210";

	// 商户的私钥
	public static String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK9ryAe1K+m3t8PArogPqEFBlYjGrmZo5O5GMsmX9u9MutuqgMkpq2LKgM08VWSFTJlybsEvDh9RhcSIcQyupJDel0TF+z2wdlt4aHkdb7m2/FeTntMTL6OC7qqe3hPOffl9X8sBUhEp79atkpxC9mQiYBVXGzb8wMGc0SUwdv6LAgMBAAECgYAD3ieB6/+03oUhvszaWSYHkk+evWq4/VUW39tc0In0SsfP8hl21gFeY0Klw8/KMJo4w+onPkdcb2q4o52CfxNHyRhOEEOCwuqFLMGFjJsf4TqlhExx+hsuApy/uTg4xpBwnp1WjPoNHGsAo/6nnO0L4QiS2z+r3CXVYYASsrvkWQJBANSkcXXQLD6/AK5yea7l+2/reu3SgLwJesfLVJPctDDqg2wKUB6o16mnC2aHKU8h2QodJaAzD5KSRZZlTkLUSe8CQQDTMHMwtW1+PrDXTUjugdyv2ldA/9O/pbIRotVtsdQMnmmoG1dlp51WdDBCvZEk9vKLKOm48HYbZgUW/n68R6ElAkEAn4MEAca5ihAp6LLDCSpIZXqV6pVAMM5DpmCm/4xON2uUTpWl6Hnr3b4LVUwK9uuDLo0Szou/IMpNHTa9cHBjTQJBAILGwt4LyzTdD1cT5bDEO+utklCO2woXSjB/nBikgQIbaqQN4k3xwI2Tv3rktqekQEeKW0kJpqmKwGYfzE09Mf0CQE0DGNcwWrpmkDe4bH+9exK/LvH4AZni3yfTyGmluQ1aNHndUm6FaYB5dA8JoVLc0q85bRfwcngKa6j2jtphcsA=";

	// 支付宝的公钥，无需修改该值
	public static String app_id = "2016111702901409";

	// 阿里的公钥，无需修改该值
	public static String ali_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "home:\\";

	public static String content_type = "json";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";

	// 签名方式 不需修改
	public static String sign_type = "RSA";

	// 网关
	public static String url = "https://openapi.alipay.com/gateway.do";

}
