package kmg.core.infrastructure.utils;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import kmg.core.infrastructure.type.KmgString;
import kmg.core.infrastructure.types.KmgMsgMessageTypes;

/**
 * KMGメッセージユーティリティ<br>
 *
 * @author KenichiroArai
 * @sine 1.0.0
 * @version 1.0.0
 */
public final class KmgMessageUtils {

    /** リソースバンドルマップ */
    private static final Map<String, ResourceBundle> bundleMap;

    /** プロパティファイル名の配列 */
    private static final String[] PROPERTY_FILES = {
        "messages", "messages-log"
    };

    static {

        /* リソースバンドルを読み込み、マップに格納する */
        bundleMap = new HashMap<>();

        // 各プロパティファイルのリソースバンドルを取得し、リソースバンドルマップに登録する
        for (final String propertyFile : KmgMessageUtils.PROPERTY_FILES) {

            KmgMessageUtils.bundleMap.put(propertyFile, ResourceBundle.getBundle(propertyFile));

        }

    }

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     */
    private KmgMessageUtils() {

        // 処理なし
    }

    /**
     * メッセージを取得する<br>
     *
     * @author KenichiroArai
     * @sine 1.0.0
     * @version 1.0.0
     * @param type
     *                    メッセージの種類
     * @param messageArgs
     *                    メッセージの引数
     * @return メッセージ
     */
    public static String getMessage(final KmgMsgMessageTypes type, final Object[] messageArgs) {

        String result = KmgString.EMPTY;

        /* 引数のチェック */

        if (type == null) {

            return result;

        }

        if (type.getCode() == null) {

            return result;

        }

        /* 全てのプロパティファイルから該当するメッセージを探す */
        String messagePattern = null;

        for (final ResourceBundle bundle : KmgMessageUtils.bundleMap.values()) {

            try {

                messagePattern = bundle.getString(type.getCode());
                break;

            } catch (@SuppressWarnings("unused") final java.util.MissingResourceException e) {

                // 該当するメッセージが見つからない場合は次のバンドルを探す
                continue;

            }

        }

        // メッセージが見つからないか
        if (messagePattern == null) {
            // メッセージが見つからない場合

            return result;

        }

        /* メッセージの引数を埋め込みメッセージを作成する */

        if (messageArgs == null) {

            result = messagePattern;
            return result;

        }

        if (messageArgs.length <= 0) {

            result = messagePattern;
            return result;

        }

        result = MessageFormat.format(messagePattern, messageArgs);

        return result;

    }
}
