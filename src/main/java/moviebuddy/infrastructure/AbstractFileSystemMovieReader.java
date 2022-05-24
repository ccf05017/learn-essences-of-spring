package moviebuddy.infrastructure;

import moviebuddy.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public abstract class AbstractFileSystemMovieReader implements ResourceLoaderAware {

    private final Logger log = LoggerFactory.getLogger(getClass());
    protected String metadata;
    private ResourceLoader resourceLoader;

    public String getMetadata() {
        return metadata;
    }

    @Value("${movie.metadata}")
    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        Resource resource = getMetaDataResource();
        if (!resource.exists()) {
            throw new FileNotFoundException(metadata);
        }
        if (!resource.isReadable()) {
            throw new ApplicationException("cannot read to metadata");
        }
        log.info(resource + " is ready.");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource getMetaDataResource() {
        return resourceLoader.getResource(getMetadata());
    }

    @PreDestroy
    public void destroy() throws Exception {
        log.info("bean destroyed");
    }

}
