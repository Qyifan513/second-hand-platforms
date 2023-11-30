package com.platforms.media.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.platforms.media.model.dto.UploadFileParamsDto;
import com.platforms.media.model.dto.UploadFileResultDto;
import com.platforms.media.model.po.MediaFiles;
import com.platforms.secondhandbase.RestResponse;

import java.util.List;

/**
 * <p>
 * 媒资信息 服务类
 * </p>
 *
 * @author itcast
 * @since 2023-08-20
 */
public interface MediaService extends IService<MediaFiles> {
    /**
     * 更新单个文件所属商品信息
     * @param filename 文件名
     * @param updateGoods 商品名
     * @return UploadFileResultDto
     */
    boolean updateByNameforGoods(String filename, String updateGoods);
    /**
     * 更新一系列文件所属商品信息
     * @param filenames 文件名
     * @param updateGoods 商品名
     * @return UploadFileResultDto
     */
    boolean updateByNamesforGoods(List<Object> filenames, String updateGoods);
    /**
     * 上传文件
     * @param schoolId 学校id
     * @param uploadFileParamsDto 文件信息
     * @param localFilePath 文件本地路径
     * @param objectName 如果传入objectname要按objectname的目录去存储，如果不传就按年月日目录结构去存储
     * @return UploadFileResultDto
     */
    public UploadFileResultDto uploadFile(Long schoolId, UploadFileParamsDto uploadFileParamsDto, String localFilePath, String objectName) throws Exception;

    public MediaFiles addMediaFilesToDb(Long companyId,String fileMd5,UploadFileParamsDto uploadFileParamsDto,String bucket,String objectName);
    /**
     * 检查文件是否存在
     *
     * @param fileMd5 文件的md5
     * @return
     */
    RestResponse<Boolean> checkFile(String fileMd5);

    /**
     * 检查分块是否存在
     * @param fileMd5       文件的MD5
     * @param chunkIndex    分块序号
     * @return
     */
    RestResponse<Boolean> checkChunk(String fileMd5, int chunkIndex);
    /**
     * 上传分块
     * @param fileMd5   文件MD5
     * @param chunk     分块序号
     * @param bytes     文件字节
     * @return
     */
    RestResponse uploadChunk(String fileMd5, int chunk, String bytes);
    /**
     * @description 合并分块
     * @param schoolId  学校id
     * @param fileMd5  文件md5
     * @param chunkTotal 分块总和
     * @param uploadFileParamsDto 文件信息
     * @return com.xuecheng.base.model.RestResponse
     * @author Mr.M
     * @date 2022/9/13 15:56
     */
    public RestResponse mergechunks(Long schoolId,String fileMd5,int chunkTotal,UploadFileParamsDto uploadFileParamsDto);
}
