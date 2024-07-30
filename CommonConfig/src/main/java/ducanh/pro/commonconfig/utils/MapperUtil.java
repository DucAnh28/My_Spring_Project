package ducanh.pro.commonconfig.utils;

import lombok.Data;
import lombok.Getter;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class MapperUtil {

    private ModelMapper modelMapper;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @SneakyThrows
    public <S, T> List<T> mapList(List<S> sources, Class<T> targetClass) {
        List<T> results = new ArrayList<>();

        for (S source : sources) {
            T targetObj = targetClass.getConstructor().newInstance();
            modelMapper.map(source, targetObj);
            results.add(targetObj);
        }

        return results;
    }

}
