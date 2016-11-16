package makeVoca;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vocaService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insert(vocaVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertVoca", vo);
	}

	public List<?> vocaList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("selectList");
	}

	public int insertMean(String mean) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertMean", mean);
				
	}
	

}
