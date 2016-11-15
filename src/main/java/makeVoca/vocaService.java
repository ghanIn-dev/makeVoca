package makeVoca;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vocaService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insert(String string) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertVoca", string);
	}

	public List<?> vocaList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectList");
	}
	

}
