package jp.ac.ohara.E.seisaku.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.E.seisaku.model.ShifutoHyou;
import jp.ac.ohara.E.seisaku.repository.ShifutoRepository;

 
@Service
@Transactional
public class  ShifutoService{
 
    @Autowired
    private ShifutoRepository repository;
 
    /**
     * 学生一覧の取得
     * @return List<Gakusei>
     */
    public List<ShifutoHyou> getShifutoList() {
        List<ShifutoHyou> entityList = this.repository.findAll();
        return entityList;
    }
 
    /**
     * 詳細データの取得
     * @param @NonNull Long index
 
     */
    public ShifutoHyou get(@NonNull Long index) {
        ShifutoHyou shifuto = this.repository.findById(index).orElse(new ShifutoHyou());
        return shifuto;
    }
 
    public void save(@NonNull ShifutoHyou shifuto) {
        this.repository.save(shifuto);
    }
 
    /**
     * アドレス帳データの削除
     * @param @NonNull Long index
     */
    public void delete(@NonNull Long index) {
        this.repository.deleteById(index);
    }
}