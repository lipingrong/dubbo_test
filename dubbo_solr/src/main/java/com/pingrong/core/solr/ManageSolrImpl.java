package com.pingrong.core.solr;

import com.pingrong.core.service.ManageSolr;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/20.
 */
@Service("manageSolr")
public class ManageSolrImpl implements ManageSolr {
    @Autowired
    private SolrServer solrServer;
    @Override
    public void add() throws Exception {
        //添加对象
        SolrInputDocument solrInputDocument;
        for (int i = 10; i < 20; i++) {
            solrInputDocument = new SolrInputDocument();
            solrInputDocument.addField("id",String.valueOf(i) );
            solrInputDocument.addField("name_ik","我是第"+i+"个" );
            //每次都需要创新新的SolrDocment对象
            solrServer.add(solrInputDocument);
        }
        solrServer.commit();
    }

    @Override
    public void search() throws Exception {
        //查询对象
        SolrQuery solrQuery = new SolrQuery();
        //name_ik是查询字段，10为内容
        solrQuery.set("q","name_ik:我");
        //过滤条件（可多个）
        //设置查询条件 [1 TO *]大于1的  [* TO 10] 小于10的
        solrQuery.addFilterQuery("id:[10 TO 15]");
        //排序
        solrQuery.setSort("id", SolrQuery.ORDER.desc);
        //高亮 开关
        solrQuery.setHighlight(true);
        //高亮字段（属性）
        solrQuery.addHighlightField("name_ik");
        //高亮样式    开头
        solrQuery.setHighlightSimplePre("<span style='color:red'>");
        //高亮样式    结尾
        solrQuery.setHighlightSimplePost("</span>");
        //设置分页
        solrQuery.setStart(5);//开始行
        solrQuery.setRows(2);//查询多少条（每页显示条数）
        //查询
        QueryResponse response = solrServer.query(solrQuery);
        //结果集
        SolrDocumentList docs = response.getResults();
        //高亮内容
        //Map<k,v> k : 数据ID-标识符
        //v : Map<k,v> k : name_ik  -----solrQuery.addHighlightField("name_ik")查询时设置的高亮属性名称
        //v : List<String> : name_ik的内容（经过了拼接，设置了高亮）
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
        for(SolrDocument doc : docs){
            String id = String.valueOf(doc.get("id"));
            //获取高亮配置的内容
            Map<String, List<String>> stringListMap = highlighting.get(id);
            //获取设置的高亮属性
            List<String> name_ik = stringListMap.get("name_ik");
            String s = name_ik.get(0); //获取内容，多数情况只有一个
            System.out.println(s);
        }
    }
}
