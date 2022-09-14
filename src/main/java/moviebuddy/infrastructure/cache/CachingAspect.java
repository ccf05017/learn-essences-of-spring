package moviebuddy.infrastructure.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.Objects;

@Aspect
public class CachingAspect {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final CacheManager cacheManager;

    public CachingAspect(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @Around("target(moviebuddy.domain.MovieReader)")
    public Object doCachingReturnValue(ProceedingJoinPoint joinPoint) throws Throwable {
        Cache cache = cacheManager.getCache(joinPoint.getClass().getName());
        Object cachedValue = cache.get(joinPoint.getSignature().getName(), Object.class);
        if (Objects.nonNull(cachedValue)) {
            log.info("return cached data. [{}]", joinPoint);
            return cachedValue;
        }
        cachedValue = joinPoint.proceed();
        cache.put(joinPoint.getSignature().getName(), cachedValue);
        log.info("caching return value. [{}]", joinPoint);

        return cachedValue;
    }

}
