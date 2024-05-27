package com.gh.reto.util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class FunctionUtil {

    public static Date stringToDateyyyyMMdd(String fecha) {
        return stringToDate(fecha, ConstantsUtil.FORMAT_YYYYMMDD);
    }

    private static Date stringToDate(String fecha, String formato) {
        if (fecha == null || fecha.isEmpty()) return null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato, Locale.ENGLISH);
            simpleDateFormat.setLenient(Boolean.FALSE);
            return simpleDateFormat.parse(fecha);
        } catch (ParseException e) {
            log.error("Parse Exception Date: {}", e.getMessage());
            throw new ServiceException(String.format(ConstantsUtil.ERROR_DATE_FORMAT, fecha));
        }
    }

}