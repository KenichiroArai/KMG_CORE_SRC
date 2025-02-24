package kmg.core.domain.service.impl;

import kmg.core.domain.service.KmgPfaMeasService;
import kmg.core.infrastructure.model.KmgPfaMeasModel;

/**
 * KMG性能測定サービス<br>
 *
 * @author KenichiroArai
 *
 * @since 0.1.0
 *
 * @version 0.1.0
 */
public class KmgPfaMeasServiceImpl implements KmgPfaMeasService {

    /**
     * 名称
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private final String name;

    /**
     * KMG性能測定モデル
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    private final KmgPfaMeasModel kmgPfaMeasModel;

    /**
     * コンストラクタ<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @param name
     *             名称
     */
    public KmgPfaMeasServiceImpl(final String name) {

        this.name = name;
        this.kmgPfaMeasModel = this.createKmgPfaMeasModel();

    }

    /**
     * 終了<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    @Override
    public void end() {

        this.kmgPfaMeasModel.end();
        // TODO 2025/02/02 KenichiroArai KMGLOGI12001={0}：終了。経過時間=[{1}{2}]
        System.out.println(String.format("%s：終了。経過時間=[%f%s]", this.name, this.kmgPfaMeasModel.getElapsedTime(), //$NON-NLS-1$
            this.kmgPfaMeasModel.getTimeUnit().getUnitName()));

    }

    /**
     * 開始<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     */
    @Override
    public void start() {

        // TODO 2025/02/02 KenichiroArai KMGLOGI12000={0}：開始
        System.out.println(String.format("%s：開始", this.name)); //$NON-NLS-1$
        this.kmgPfaMeasModel.start();

    }

    /**
     * KMG性能測定モデルを生成する<br>
     *
     * @author KenichiroArai
     *
     * @since 0.1.0
     *
     * @version 0.1.0
     *
     * @return KMG性能測定モデル
     */
    @SuppressWarnings("static-method")
    protected KmgPfaMeasModel createKmgPfaMeasModel() {

        final KmgPfaMeasModel result = new KmgPfaMeasModel();
        return result;

    }

}
