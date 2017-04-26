## Area - Indonesia
![Flag of Indonesia](.README/FlagOfIndonesia.png)

_Powered by **[GO Indonesia](http://goindonesia.id)**_


**Area** : _Basic concept is to provide geographic information related with it's administrative._

**Indonesia**: _Related to Republic Indonesia administrative._

#### This project provides data :
* Provinces _(in bahasa: Provinsi)_
* Regencies _(in bahasa: Kota / Kabupaten)_
* Districts _(in bahasa: Kecamatan)_
* Village _(in bahasa: Desa / Kelurahan)_

#### with several features :
* Generally
    1. Search (`/search?keyword=<your keyword>`)
* Provinces
    1. List all (`/province/all`)
    2. Select with code (`/province/one?code=<province code>`)
    3. Search in provinces (`/province/search?keyword=<your keyword>`)
* Regencies
    1. List all (`/regency/all`)
    2. Select with code (`/regency/one?code=<regency code>`)
    3. Search in regencies (`/regency/search?keyword=<your keyword>`)
    4. List in specific province (`/regency/parent?code=<province code>`)
* Districts
    1. List all (`/district/all`)
    2. Select with code (`/district/one?code=<district code>`)
    3. Search in districts (`/district/search?keyword=<your keyword>`)
    4. List in specific regency (`/district/parent?code=<regency code>`)
* Villages
    1. List all (`/village/all`)
    2. Select with code (`/village/one?code=<village code>`)
    3. Search in villages (`/village/search?keyword=<your keyword>`)
    4. List in specific district (`/village/parent?code=<district code>`)


#### Documentations
###### Version 1.0
* [Postman Collection v1](documentations/1.0/INDONESIA.postman_collection_v1.json)
* [Postman Collection v2](documentations/1.0/INDONESIA.postman_collection_v2.json)



#### Contributors
* Akhmad Ghozali Amrulloh ([ghostzali](https://github.com/ghostzali)_09@gmail.com_)


#### License
* The scripts are license under: [MIT](license.md).
* The data (CSV and SQL) are under: [ODBL v1.0](odbl-10.md).
* The source data is attributed to [Badan Pusat Statistik (BPS) Indonesia](http://bps.go.id).


> Thanks to :
> * [Edward Samuel Pasaribu](https://github.com/edwardsamuel) with his project [Data Provinsi, Kota/Kabupaten, Kecamatan, dan Kelurahan/Desa di Indonesia](https://github.com/edwardsamuel/Wilayah-Administratif-Indonesia)
> * [Badan Pusat Statistik (BPS) Indonesia](http://bps.go.id) for all effort.
