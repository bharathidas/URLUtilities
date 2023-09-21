// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package mendixsso.actions;

import com.mendix.systemwideinterfaces.MendixRuntimeException;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.util.Base64;

public class DecryptString extends CustomJavaAction<java.lang.String>
{
	private java.lang.String value;
	private java.lang.String key;
	private java.lang.String prefix;

	public DecryptString(IContext context, java.lang.String value, java.lang.String key, java.lang.String prefix)
	{
		super(context);
		this.value = value;
		this.key = key;
		this.prefix = prefix;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
        if (this.value == null || !isStartsWithRightPrefix())
            return null;
        if (this.prefix == null || this.prefix.isEmpty())
            throw new MendixRuntimeException("Prefix should not be empty");
        if (this.key == null || this.key.isEmpty())
            throw new MendixRuntimeException("Key should not be empty");
        if (this.key.length() != 16)
            throw new MendixRuntimeException("Key length should be 16");

        String decryptedText = null;

        if (isEncryptedWithLegacyAlgorithm(this.value)) {
            decryptedText = decryptUsingLegacyAlgorithm();
        } else {
            decryptedText = decryptUsingGcm();
        }

        return decryptedText;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "DecryptString";
	}

	// BEGIN EXTRA CODE
    private final int GCM_TAG_LENGTH = 16; // in bytes
    private final String LEGACY_PREFIX = "{AES}";
    private final String WRONG_KEY_ERROR_MESSAGE = "Cannot decrypt the text because it was either NOT encrypted with a key of length 16 or they key is different";

    private String decryptUsingGcm() throws Exception {
        String[] s = this.value.substring(this.prefix.length()).split(";");

        if (s.length < 2) //Not an encrypted string, just return the original value.
            return this.value;

        Cipher c = Cipher.getInstance("AES/GCM/PKCS5PADDING");
        SecretKeySpec k = new SecretKeySpec(this.key.getBytes(), "AES");

        try {
            GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, Base64.getDecoder().decode(s[0]));
            c.init(Cipher.DECRYPT_MODE, k, spec);
            byte[] encryptedData = Base64.getDecoder().decode(s[1]);
            return new String(c.doFinal(encryptedData));
        } catch (InvalidAlgorithmParameterException | BadPaddingException ex) {
            if (isEncryptedWithWrongKey(ex.getMessage()))
                throw new MendixRuntimeException(WRONG_KEY_ERROR_MESSAGE);
            else throw ex;
        }
    }

    private boolean isEncryptedWithWrongKey(String message) {
        return
                message.equals("Wrong IV length: must be 16 bytes long") ||
                        message.equals("Given final block not properly padded");
    }

    private String decryptUsingLegacyAlgorithm() throws Exception {
        String[] s = this.value.substring(LEGACY_PREFIX.length()).split(";");

        if (s.length < 2) //Not an encrypted string, just return the original value.
            return this.value;

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        SecretKeySpec k = new SecretKeySpec(this.key.getBytes(), "AES");

        try {
            c.init(Cipher.DECRYPT_MODE, k, new IvParameterSpec(Base64.getDecoder().decode(s[0])));
            byte[] encryptedData = Base64.getDecoder().decode(s[1]);
            return new String(c.doFinal(encryptedData));
        } catch (InvalidAlgorithmParameterException | BadPaddingException ex) {
            if (isEncryptedWithWrongKey(ex.getMessage()))
                throw new MendixRuntimeException(WRONG_KEY_ERROR_MESSAGE);
            else throw ex;
        }
    }

    private boolean isEncryptedWithLegacyAlgorithm(String text) {
        return text.startsWith(LEGACY_PREFIX);
    }

    private boolean isStartsWithRightPrefix() {
        return this.value.startsWith(this.value) || isEncryptedWithLegacyAlgorithm(this.value);
    }
	// END EXTRA CODE
}
