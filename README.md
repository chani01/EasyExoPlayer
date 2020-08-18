# EasyExoPlayer

## SetUp
![Build Status](https://img.shields.io/badge/download-1.0.1-green.svg)

```
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```

```
dependencies {
      implementation 'com.github.chani01:EasyExoPlayer:1.0.1'
}
```

## How to use
### Player init
```
EasyExoPlayer.initPlayer(this, getString(your_app_name)
```

### SinglePlay
```
EasyExoPlayer.setDataSource(file_url)
EasyExoPlayer.play()
```

### PlayList
```
 val data = listOf(file_url1, file_url2, file_url3, file_url4)
 EasyExoPlayer.setPlayListSource(data)
 EasyExoPlayer.play()
```
