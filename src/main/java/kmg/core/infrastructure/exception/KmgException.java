package kmg.core.infrastructure.exception;

import kmg.core.infrastructure.types.KmgLogMessageTypes;

/**
 * ＫＭＧ例外<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public class KmgException extends Exception {

    /** デフォルトシリアルバージョンＵＩＤ */
    private static final long serialVersionUID = 1L;

    /** ログメッセージの種類 */
    private final KmgLogMessageTypes logMsgTypes;

    /** ログメッセージの引数 */
    private final Object[] logMsgArgs;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param errMsg
     *                    エラーメッセージ
     * @param logMsgTypes
     *                    ログメッセージの種類
     * @param logMsgArgs
     *                    ログメッセージの引数
     */
    public KmgException(final String errMsg, final KmgLogMessageTypes logMsgTypes, final Object[] logMsgArgs) {
        super(errMsg);
        this.logMsgTypes = logMsgTypes;
        this.logMsgArgs = logMsgArgs;
    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param errMsg
     *                    エラーメッセージ
     * @param logMsgTypes
     *                    ログメッセージの種類
     * @param cause
     *                    原因
     */
    public KmgException(final String errMsg, final KmgLogMessageTypes logMsgTypes, final Throwable cause) {
        super(errMsg, cause);
        this.logMsgTypes = logMsgTypes;
        this.logMsgArgs = null;
    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param errMsg
     *                    エラーメッセージ
     * @param logMsgTypes
     *                    ログメッセージの種類
     * @param logMsgArgs
     *                    ログメッセージの引数
     * @param cause
     *                    原因
     */
    public KmgException(final String errMsg, final KmgLogMessageTypes logMsgTypes, final Object[] logMsgArgs,
        final Throwable cause) {
        super(errMsg, cause);
        this.logMsgTypes = logMsgTypes;
        this.logMsgArgs = logMsgArgs;
    }

    /**
     * ログメッセージの種類を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return ログメッセージの種類
     */
    public KmgLogMessageTypes getLogMsgTypes() {
        final KmgLogMessageTypes result = this.logMsgTypes;
        return result;
    }

    /**
     * ログメッセージの引数を返す<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @return ログメッセージの引数
     */
    public Object[] getLogMsgArgs() {
        final Object[] result = this.logMsgArgs;
        return result;
    }

}
