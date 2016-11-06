package makeVoca;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vocaService {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	public int insert(vocaVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("insertVoca", vo);
	}

}
