package kmg.core.infrastructure.utils;

import java.util.Map;

/**
 * KMGマップユーティリティ<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
public final class KmgMapUtils {

    /**
     * デフォルトコンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private KmgMapUtils() {

        // 処理無し
    }

    /**
     * 対象が空か<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @param target
     *               対象
     *
     * @return true：空、false：空ではない
     */
    public static boolean isEmpty(final Map<?, ?> target) {

        boolean result = true;

        if (target == null) {

            return result;

        }

        if (target.isEmpty()) {

            return result;

        }

        result = false;
        return result;

    }

    /**
     * 対象が空ではないか<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @param target
     *               対象
     *
     * @return true：空ではない、false：空
     */
    public static boolean isNotEmpty(final Map<?, ?> target) {

        final boolean result = !KmgMapUtils.isEmpty(target);
        return result;

    }
}
