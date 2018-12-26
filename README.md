### Galatea project

#### base

* kotlin
* {mvp?mvvm} ok apply MVVM, liveData& ViewModel
* rxjava+retrofit+okhttp
* material design
* binder
* remoteView
* custom view
* etc

#### liveData+viewModel

why?
because mvp could cause a memory leak problem, for example

```
class MyPresenter{
    var mView ?= null
        set(view:MyView) = view
    ...
}

class MyView{
    val mPresenter = MyPresenter()

    override fun onCreate(){
        ...
        mPresenter.mView = this
    }
    ...
}
```

and mvvm separate view from model proxy

#### api

* https://y.qq.com/m/api/api.html
* http://qukufile2.qianqian.com/data2/pic/45463a960747fd1d0227ee7dd70e9e96/610370690/610370690.jpg
* https://api.apiopen.top/searchMusic
* https://api.apiopen.top/musicBroadcasting
* https://api.apiopen.top/musicBroadcastingDetails?channelname=public_tuijian_spring
* https://api.apiopen.top/musicDetails
* https://api.apiopen.top/musicRankings
* https://api.apiopen.top/musicRankingsDetails?type=1

#### application structure

```
GalateaApplication{
    DisplayService{
    // based on binder, offer display function, process:player
        displayList getter&setter
        play
        pause
        model setter
    }

    SplashActivity{
        // TODO
    }

    MainActivity{
        // describe=[song record], position=[left&top], widget=[button with lottie animation]
        >> RecodeActivity

        // describe=[title], position=[center&top], widget=[text]

        // describe=[search], position=[right&top], widget=[button]
        >> SearchActivity

        // describe=[playing page], position=[right&top], widget=[button with lottie animation]
        >> DisplayActivity

        // describe=[tab], position=[under toolbar], widget=[tab with anim line]

        DiscoverFragment{
        // songs form remote, api request, based on api
            // describe=[multiRecyclerView, with refresh], position=[fill], widget=[item view group]
                // describe=[song list item], position=[], widget=[index, songTitle, artist, duration etc]
                >> DisplayActivity
        }

        ListFragment{
        // there are three basic list, [favorite], [recently], [newest], and custom list
            // describe=[multiRecyclerView], position=[wrap], widget=[item view group]{
                // describe=[album list item], position=[], widget=[icon, albumTitle]
                >> AlbumActivity
            }
            // describe=[create new album], position=[under list], widget=[same with item]
            >> AlbumActivity
        }

        ProfileFragment{
        // personal information show, player setting
            // describe=[information bar], position=[top], widget=[view group]
            >> SettingProfileActivity

            // describe=[setting list], position=[wrap], widget=[multiRecyclerView]
                // describe=[item of setting label], position=[], widget=[text+button]
        }
    }

    RecordActivity{
        // describe=[back button], position=[left&top], widget=[button with lottie animation]
        >> MainActivity

        // describe=[title], position=[center&top], widget=[text]

        // describe=[record button], position=[center], widget=[custom button]
    }

    SearchActivity{
        // describe=[back button], position=[left&top], widget=[button with lottie animation]
        >> MainActivity

        // describe=[search editor], position=[center&top], widget=[text]

        // describe=[result list], position=[fill], widget=[RecyclerView]
    }

    DisplayActivity{
    // function based on ipc, music play in media process
        // describe=[song record], position=[left&top], widget=[button with lottie animation]
        >> MainActivity

        // describe=[title], position=[center&top], widget=[text]

        // describe=[display card], position=[center], widget=[cardView, with display function]
            // describe=[bg], position=[], widget=[image]
            // describe=[turn previous], position=[], widget=[button with icon]
            // describe=[play or pause], position=[], widget=[button with icon]
            // describe=[turn next], position=[], widget=[button with icon]
            // describe=[play model, such as single_cycle, album_cycle, random_cycle], position=[], widget=[button with icon]
            // describe=[show play list], position=[], widget=[button with icon]
    }

    AlbumActivity{
        // describe=[song record], position=[left&top], widget=[button with lottie animation]
        >> MainActivity

        // describe=[title], position=[center&top], widget=[text]

        // describe=[display card], position=[center], widget=[cardView, with display function]
            // describe=[bg], position=[], widget=[image]
            // describe=[album title], position=[], widget=[text, can be edit]
            // describe=[album describe], position=[], widget=[text, can be edit]
            // describe=[album bg chooser], position=[], widget=[button]

        // describe=[album list], position=[fill], widget=[recyclerView]
            // describe=[song list item], position=[], widget=[index, songTitle, artist, duration etc]
    }

    SettingProfileActivity{
        // TODO
    }

    DonateActivity{
        // TODO
    }

    RemoteView{
        // TODO
    }

    NoticeView{
        // TODO
    }
}
```