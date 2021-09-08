#import <React/RCTBridgeDelegate.h>
#import <UIKit/UIKit.h>
#import "RCTGetID.h"

@interface AppDelegate : UIResponder <UIApplicationDelegate, RCTBridgeDelegate>

@property (nonatomic, strong) UIWindow *window;
@property (nonatomic, strong) RCTGetID *getID;

@end
