package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.types.KmgMsgMessageTypes;
import kmg.core.infrastructure.utils.KmgMessageUtils;

/**
 * KMG例外<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgException extends Exception {

    /** デフォルトシリアルバージョンUID */
    private static final long serialVersionUID = 1L;

    /** メッセージメッセージの種類 */
    private KmgMsgMessageTypes messageTypes;

    /** メッセージメッセージの引数 */
    private Object[] messageArgs;

    /** メッセージ */
    private final String message;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageTypes
     *                     メッセージの種類
     */
    public KmgException(final KmgMsgMessageTypes messageTypes) {

        this(messageTypes, null, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageTypes
     *                     メッセージの種類
     * @param messageArgs
     *                     メッセージの引数
     */
    public KmgException(final KmgMsgMessageTypes messageTypes, final Object[] messageArgs) {

        this(messageTypes, messageArgs, null);

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageTypes
     *                     メッセージの種類
     * @param messageArgs
     *                     メッセージの引数
     * @param cause
     *                     原因
     */
    public KmgException(final KmgMsgMessageTypes messageTypes, final Object[] messageArgs, final Throwable cause) {

        super(cause);
        this.messageTypes = messageTypes;
        this.messageArgs = messageArgs;
        this.message = KmgMessageUtils.getMessage(messageTypes, messageArgs);

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param messageTypes
     *                     メッセージの種類
     * @param cause
     *                     原因
     */
    public KmgException(final KmgMsgMessageTypes messageTypes, final Throwable cause) {

        this(messageTypes, null, cause);

    }

    /**
     * メッセージを返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージ
     */
    @Override
    public String getMessage() {

        final String result = this.message;
        return result;

    }

    /**
     * メッセージの引数を返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージの引数
     */
    public Object[] getMessageArgs() {

        final Object[] result = this.messageArgs;
        return result;

    }

    /**
     * メッセージの種類を返す。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return メッセージの種類
     */
    public KmgMsgMessageTypes getMessageTypes() {

        final KmgMsgMessageTypes result = this.messageTypes;
        return result;

    }

    /**
     * メッセージパターンの引数の数と実際の引数の数が一致しているかチェックする。<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return true：一致している、false：一致していない
     */
    public boolean checkMessageArgsCount() {

        boolean result = false;

        /* 引数のチェック */
        if (this.messageTypes == null) {

            return result;

        }

        final String messagePattern = this.messageTypes.getCode();

        if (messagePattern == null) {

            return result;

        }

        /* メッセージパターンと引数の数のチェック */
        result = KmgMessageUtils.checkMessageArgsCount(messagePattern, this.messageArgs);

        return result;

    }
}
