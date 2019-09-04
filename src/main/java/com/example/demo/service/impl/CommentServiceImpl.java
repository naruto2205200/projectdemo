package com.example.demo.service.impl;

import com.example.demo.domain.Category;
import com.example.demo.domain.Comment;
import com.example.demo.domain.Photo;
import com.example.demo.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/8/1513:59
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public List<Comment> getCommentListByNewsId(Integer newsId) {
        return getList();
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        Category category1 = new Category();
        category1.setId(1);
        category1.setTitle("推荐");
        list.add(category1);
        Category category2 = new Category();
        category2.setId(2);
        category2.setTitle("热点");
        list.add(category2);
        Category category3 = new Category();
        category3.setId(3);
        category3.setTitle("北京");
        list.add(category3);
        Category category4 = new Category();
        category4.setId(4);
        category4.setTitle("社会");
        list.add(category4);
        Category category5 = new Category();
        category5.setId(5);
        category5.setTitle("娱乐");
        list.add(category5);
        Category category6 = new Category();
        category6.setId(6);
        category6.setTitle("国际");
        list.add(category6);
        Category category7 = new Category();
        category7.setId(7);
        category7.setTitle("军事");
        list.add(category7);
        Category category8 = new Category();
        category8.setId(8);
        category8.setTitle("科技");
        list.add(category8);
        Category category9 = new Category();
        category9.setId(9);
        category9.setTitle("电影");
        list.add(category9);
        return list;
    }

    @Override
    public List<Photo> getPhotoList(Integer cateId) {
        List<Photo> list = new ArrayList<>();
        Photo photo1 = new Photo();
        photo1.setId(1);
        photo1.setCateId(1);
        photo1.setImgUrl("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1565934121&di=9de58fa467b6dc7495eeee4c90ea1070&src=http://ac-r.static.booking.cn/images/hotel/max1024x768/987/98767654.jpg");
        list.add(photo1);
        Photo photo2 = new Photo();
        photo2.setId(2);
        photo2.setCateId(1);
        photo2.setImgUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1343015815,2335192405&fm=26&gp=0.jpg");
        list.add(photo2);
        Photo photo3 = new Photo();
        photo3.setId(3);
        photo3.setCateId(2);
        photo3.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565944192325&di=52b1f546bb9b2b8b4539d33b6092a400&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F458af12108c4da0f1cf4fe8e2713a458898e332b28196-jdjJ3j_fw658");
        list.add(photo3);
        Photo photo4 = new Photo();
        photo4.setId(4);
        photo4.setCateId(2);
        photo4.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565944192324&di=4db25d8b35ca71d2737815938834f27b&imgtype=0&src=http%3A%2F%2Fpix10.agoda.net%2FhotelImages%2F490%2F49023%2F49023_17020916180050887872.jpg%3Fs%3D1024x768");
        list.add(photo4);
        Photo photo5 = new Photo();
        photo5.setId(5);
        photo5.setCateId(2);
        photo5.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565944192323&di=ae67e6380c4e4cfadd3f82234fcf3751&imgtype=0&src=http%3A%2F%2Fmedia-cdn.tripadvisor.com%2Fmedia%2Fphoto-s%2F01%2F3e%2F05%2F40%2Fthe-sandbar-that-links.jpg");
        list.add(photo5);
        Photo photo6 = new Photo();
        photo6.setId(6);
        photo6.setCateId(3);
        photo6.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565944192321&di=3d2349942f2e93b57c7321c5bcb76587&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F5419a2aa4db24f540d4b6fa405c8923a8b905055e550-3FP3ty_fw658");
        list.add(photo6);
        Photo photo7 = new Photo();
        photo7.setId(7);
        photo7.setCateId(3);
        photo7.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565944192320&di=f3f4c3a07dc0a7e00ca8ca8046dd3236&imgtype=0&src=http%3A%2F%2Fpix0.agoda.net%2FhotelImages%2F490%2F49023%2F49023_17021011350050904933.jpg%3Fs%3D1024x768");
        list.add(photo7);
        Photo photo8 = new Photo();
        photo8.setId(8);
        photo8.setCateId(3);
        photo8.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565944192319&di=fd12ae6b93671077ee5dd66d9038dae9&imgtype=0&src=http%3A%2F%2Fac-q.static.booking.cn%2Fimages%2Fhotel%2Fmax1024x768%2F111%2F111146714.jpg");
        list.add(photo8);
        Photo photo9 = new Photo();
        photo9.setId(9);
        photo9.setCateId(4);
        photo9.setImgUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565944192318&di=cb8ba35c5a9e7b884a29001598f3827a&imgtype=0&src=http%3A%2F%2Fimg1.gamersky.com%2Fimage2013%2F03%2F20130320r_260%2Fgamersky_21small_42_2013320108B7B.jpg");
        list.add(photo9);
        return list;
    }

    private List<Comment> getList(){
        List<Comment> resultList = new ArrayList<>();
        Comment comment1 = new Comment();
        comment1.setId(1);
        comment1.setNewsId(1);
        comment1.setUserName("李四");
        comment1.setAddTime("2019-08-15 12:12:12");
        comment1.setContent("这条新闻不错！");
        resultList.add(comment1);

        Comment comment2 = new Comment();
        comment2.setId(2);
        comment2.setNewsId(1);
        comment2.setUserName("李四22");
        comment2.setAddTime("2019-08-15 11:12:12");
        comment2.setContent("这条新闻不错！");
        resultList.add(comment2);

        Comment comment3 = new Comment();
        comment3.setId(3);
        comment3.setNewsId(1);
        comment3.setUserName("李四21");
        comment3.setAddTime("2019-08-15 13:12:12");
        comment3.setContent("这条新闻不错！!");
        resultList.add(comment3);

        return resultList;
    }


}
